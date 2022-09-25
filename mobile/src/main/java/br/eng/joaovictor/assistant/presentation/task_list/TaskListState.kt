package br.eng.joaovictor.assistant.presentation.task_list

import br.eng.joaovictor.assistant.data.datasource.model.Task

data class TaskListState(
    val tasks: List<Task> = emptyList(),
    val isLoading: Boolean = false,
    val error: Throwable? = null
)