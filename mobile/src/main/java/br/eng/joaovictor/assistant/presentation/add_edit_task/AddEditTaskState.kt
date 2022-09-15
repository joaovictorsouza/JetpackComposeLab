package br.eng.joaovictor.assistant.presentation.add_edit_task

data class AddEditTaskState (
    val title : String = "",
    val description : String = "",
    val isRecurrent : Boolean = false
)