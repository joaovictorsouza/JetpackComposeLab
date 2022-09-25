
package br.eng.joaovictor.assistant.presentation.add_edit_task


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import br.eng.joaovictor.assistant.R
import br.eng.joaovictor.assistant.feature.home.presentation.theme.AssistantTheme
import br.eng.joaovictor.assistant.presentation.add_edit_task.components.AddTaskHeader
import br.eng.joaovictor.assistant.presentation.add_edit_task.components.TaskTypeSelection
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun AddEditTaskScreen(
    navController: NavController,
    viewModel: AddEditTaskViewModel = hiltViewModel(),
) {
    val state = remember {viewModel.state}.value

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val successMessage = stringResource(R.string.add_task_success_message)

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is AddTaskUIEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(
                        message = event.message.asString(context),
                    )
                }
                is AddTaskUIEvent.SaveNote -> {
                    snackbarHostState.showSnackbar(
                        message = successMessage,
                    )
                }
            }
        }
    }

    AssistantTheme {
        Scaffold(
            snackbarHost = {
                SnackbarHost(
                    hostState = snackbarHostState,
                    modifier = Modifier
                        .navigationBarsPadding(),
                    snackbar = { data ->
                        Snackbar(
                            snackbarData = data,
                            modifier = Modifier
                                .navigationBarsPadding()
                        )
                    }
                )
            },
            bottomBar = {
                        BottomAppBar(){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 5.dp, end = 5.dp, bottom = 5.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(
                                    onClick = { navController.popBackStack() },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                                    ),
                                    content = {
                                        Text(stringResource(id = R.string.buttom_cancel_captilized))
                                    })
                                Button(
                                    onClick = { viewModel.onEvent(AddEditTaskEvent.OnSaveTask) },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                                    ),
                                    content = {
                                        Text(stringResource(id = R.string.buttom_continue_captilized))
                                    }

                                )

                            }
                        }
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxHeight(.5f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(.9f),
                            label = { Text("Título") },
                            placeholder = { Text(text = stringResource(id = R.string.add_task_title_placeholder)) },
                            value = state.title,
                            isError = state.isTitleInvalid,
                            onValueChange = {
                                viewModel.onEvent(
                                    AddEditTaskEvent.OnTaskTitleChanged(
                                        it
                                    )
                                )
                            })
                    }

                    TaskTypeSelection(
                        selectedType = state.type,
                        onSelected = { viewModel.onEvent(AddEditTaskEvent.OnTaskTypeChipClicked(it)) }
                    )

                }

            })
    }
}
