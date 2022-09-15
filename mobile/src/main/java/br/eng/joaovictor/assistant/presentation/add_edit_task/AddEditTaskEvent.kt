package br.eng.joaovictor.assistant.presentation.add_edit_task
import androidx.compose.ui.focus.FocusState


sealed class AddEditTaskEvent {
    data class OnTaskTitleChanged(val value: String): AddEditTaskEvent()
    data class OnTaskDescriptionChanged(val value: String): AddEditTaskEvent()
    object OnSaveTask: AddEditTaskEvent()
}