package br.eng.joaovictor.assistant.presentation.task_list

sealed class TaskListEvent {
    data class OnClick(val id: Int) : TaskListEvent()
}