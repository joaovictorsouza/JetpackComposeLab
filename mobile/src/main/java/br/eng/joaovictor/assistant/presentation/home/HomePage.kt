@file:OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)

package br.eng.joaovictor.assistant.presentation.home

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.eng.joaovictor.assistant.feature.home.presentation.theme.AssistantTheme
import br.eng.joaovictor.assistant.presentation.util.Screen

@Composable
fun HomePage(navController: NavController) {
    AssistantTheme {
        Scaffold(
            topBar = { TopAppBar(title = {Text("Assistente")}) },
            floatingActionButton = { AddNewFAB(navController)},
            floatingActionButtonPosition = FabPosition.End,
            content = { innerPadding ->
                LazyColumn(
                    modifier = Modifier.consumedWindowInsets(innerPadding),
                    contentPadding = innerPadding,
                ){

                }
            }
        )
    }
}

@Composable
fun AddNewFAB(navController: NavController){
    ExtendedFloatingActionButton(
        onClick = { navController.navigate(Screen.AddEditTask.route) },
    ) {
        Icon(Icons.Filled.Add, "Adicionar nova tarefa")
        Spacer(modifier = Modifier.width(6.dp))
        Text("Adicionar")
    }
}