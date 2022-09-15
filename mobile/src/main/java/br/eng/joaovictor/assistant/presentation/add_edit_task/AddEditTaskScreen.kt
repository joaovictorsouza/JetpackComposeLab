package br.eng.joaovictor.assistant.presentation.add_edit_task

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import br.eng.joaovictor.assistant.feature.home.presentation.theme.AssistantTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditTaskScreen(
    navController: NavController,
    viewModel: AddEditTaskViewModel = hiltViewModel(),
){
    val state = viewModel.state.value
    AssistantTheme() {
        Column() {
            OutlinedTextField(value = state.title, onValueChange =  { viewModel.onEvent(AddEditTaskEvent.OnTaskTitleChanged(it)) })
        }
    }
}