package br.eng.joaovictor.assistant.presentation.add_edit_task

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import br.eng.joaovictor.assistant.data.datasource.model.Task
import br.eng.joaovictor.assistant.domain.use_case.task.TaskUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

@HiltViewModel
class AddEditTaskViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var state = mutableStateOf(AddEditTaskState())


    fun onEvent(event: AddEditTaskEvent) {
        when(event) {
            is AddEditTaskEvent.OnTaskTitleChanged -> {
                state.value = state.value.copy(title = event.value)
            }

            is AddEditTaskEvent.OnTaskDescriptionChanged -> {
                state.value = state.value.copy(description = event.value)
            }
            AddEditTaskEvent.OnSaveTask -> TODO()
        }
    }
}