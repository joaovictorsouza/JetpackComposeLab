package br.eng.joaovictor.assistant.presentation.add_edit_task

import br.eng.joaovictor.assistant.data.datasource.enums.TaskTypeEnum

data class AddEditTaskState (
    val title : String = "",
    val type : TaskTypeEnum = TaskTypeEnum.TASK,
    val isTitleInvalid : Boolean = false
)