@file:OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class,
    ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class
)

package br.eng.joaovictor.assistant.presentation.task_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import br.eng.joaovictor.assistant.feature.home.presentation.theme.AssistantTheme
import br.eng.joaovictor.assistant.presentation.add_edit_task.AddEditTaskScreen
import br.eng.joaovictor.assistant.presentation.task_list.component.TaskItem
import kotlinx.coroutines.launch

@Composable
fun TaskListScreen(navController: NavController,
                   viewModel: TaskListViewModel = hiltViewModel(),
) {
    val state = remember {viewModel.state}.value

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded }
    )
    val coroutineScope = rememberCoroutineScope()

    AssistantTheme {
        BoxWithConstraints {
            val sheetHeight = this.constraints.maxHeight * 0.5f
            ModalBottomSheetLayout(
                modifier = Modifier.wrapContentSize(),
                sheetElevation = 8.dp,
                sheetState = sheetState,
                sheetContent = {
                    Box(
                        modifier = Modifier.height(with(LocalDensity.current) { sheetHeight.toDp() }),
                    content = { AddEditTaskScreen(navController = navController) }
                    )
                }) {
                Scaffold(
                    topBar = { TopAppBar(title = { Text("Assistente") }) },
                    content = { innerPadding ->
                        LazyColumn(
                            modifier = Modifier.consumedWindowInsets(innerPadding),
                            contentPadding = innerPadding,
                        ) {
                            items(state.tasks.size) { index ->
                                TaskItem(taskItem = state.tasks[index])
                            }

                        }
                    },
                    bottomBar = {
                        BottomAppBar(
                            floatingActionButton = {
                                AddNewFAB(
                                    navController = navController,
                                    sheetState = {
                                        coroutineScope.launch {
                                            sheetState.show()
                                        }
                                    }
                                )
                            },                            actions = {
                                IconButton(onClick = { /* doSomething() */ }) {
                                    Icon(Icons.Filled.Check, contentDescription = "Localized description")
                                }
                                IconButton(onClick = { /* doSomething() */ }) {
                                    Icon(
                                        Icons.Filled.Edit,
                                        contentDescription = "Localized description",
                                    )
                                }
                            }
                        )
                    }
                )
            }


            }
        }
    }

@Composable
fun AddNewFAB(navController: NavController,  sheetState: () -> Unit){
    FloatingActionButton(
        onClick = sheetState,
    ) {
        Icon(Icons.Filled.Add, "Adicionar nova tarefa")
    }
}