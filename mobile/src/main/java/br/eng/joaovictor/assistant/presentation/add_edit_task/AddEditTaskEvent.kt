package br.eng.joaovictor.assistant.presentation.add_edit_task
import androidx.compose.ui.focus.FocusState
import br.eng.joaovictor.assistant.data.datasource.enums.TaskTypeEnum


sealed class AddEditTaskEvent {
    data class OnTaskTitleChanged(val value: String): AddEditTaskEvent()
    data class OnTaskTypeChipClicked(val type: TaskTypeEnum) : AddEditTaskEvent()
    object OnCancelButtonPressed: AddEditTaskEvent()
    object OnSaveTask: AddEditTaskEvent()
}