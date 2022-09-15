package br.eng.joaovictor.assistant.presentation.util

// screen sealed class
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddEditTask : Screen("add_edit_task")
}