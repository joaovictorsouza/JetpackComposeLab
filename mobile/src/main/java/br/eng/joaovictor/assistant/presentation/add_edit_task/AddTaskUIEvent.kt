package br.eng.joaovictor.assistant.presentation.add_edit_task

import br.eng.joaovictor.assistant.core.util.UiText

sealed class AddTaskUIEvent {
    data class ShowSnackbar(val message: UiText.StringResource): AddTaskUIEvent()
    object SaveNote: AddTaskUIEvent()
}