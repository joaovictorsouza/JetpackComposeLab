package br.eng.joaovictor.assistant.presentation.task_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.eng.joaovictor.assistant.di.domain.use_case.task.TaskUseCases
import br.eng.joaovictor.assistant.presentation.add_edit_task.AddEditTaskState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var state = mutableStateOf(TaskListState())

    private var getTasksJob : Job? = null

    init {
        getAllTasks()
    }
    fun onEvent(event: TaskListEvent) {
       when (event) {
           is TaskListEvent.OnClick -> {

           }
       }
   }

    private fun getAllTasks(){
        getTasksJob?.cancel()
        getTasksJob = taskUseCases.getAllTasks()
            .onEach { tasks ->
                state.value = state.value.copy(tasks = tasks)
            }
            .launchIn(viewModelScope)
    }
}