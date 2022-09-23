package br.eng.joaovictor.assistant.presentation.add_edit_task

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.eng.joaovictor.assistant.R
import br.eng.joaovictor.assistant.core.util.UiText
import br.eng.joaovictor.assistant.data.datasource.model.Task
import br.eng.joaovictor.assistant.di.domain.use_case.task.TaskUseCases
import br.eng.joaovictor.assistant.di.domain.util.InvalidTaskException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditTaskViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var state = mutableStateOf(AddEditTaskState())


    private val _eventFlow = MutableSharedFlow<AddTaskUIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    fun onEvent(event: AddEditTaskEvent) {
        when(event) {
            is AddEditTaskEvent.OnTaskTitleChanged -> {
                state.value = state.value.copy(title = event.value)
            }

            AddEditTaskEvent.OnSaveTask -> {
                viewModelScope.launch {
                    try {

                        if(state.value.title.isBlank()) {
                            state.value = state.value.copy(isTitleInvalid = true)
                            throw InvalidTaskException(UiText.StringResource(R.string.add_task_empty_title_error))
                        }

                        taskUseCases.addTask(
                            Task(
                                uid = 0,
                                title = state.value.title,
                                type = state.value.type,
                                createdAt = 0,
                                updatedAt = 0
                            )
                        )

                        _eventFlow.emit(AddTaskUIEvent.SaveNote)

                } catch(e: InvalidTaskException) {
                    _eventFlow.emit(
                        AddTaskUIEvent.ShowSnackbar(
                            message = e.resourceMessage ?: UiText.StringResource(R.string.add_task_generic_error)
                        )
                    )
                }
                }
            }

            AddEditTaskEvent.OnCancelButtonPressed -> {


            }
            is AddEditTaskEvent.OnTaskTypeChipClicked -> {
                state.value = state.value.copy(type = event.type)
            }
        }
    }
}