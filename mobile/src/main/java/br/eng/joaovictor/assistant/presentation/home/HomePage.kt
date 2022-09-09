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
import br.eng.joaovictor.assistant.feature.home.presentation.theme.AssistantTheme

@Composable
fun HomePage() {
    AssistantTheme {
        Scaffold(
            topBar = { TopAppBar(title = {Text("Assistente")}) },
            floatingActionButton = { AddNewFAB()},
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
fun AddNewFAB(){
    ExtendedFloatingActionButton(
        onClick = { /*TODO*/ },
    ) {
        Icon(Icons.Filled.Add, "Adicionar nova tarefa")
        Spacer(modifier = Modifier.width(6.dp))
        Text("Adicionar")
    }
}