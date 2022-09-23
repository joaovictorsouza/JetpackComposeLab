@file:OptIn(ExperimentalMaterialApi::class)

package br.eng.joaovictor.assistant.presentation.add_edit_task


import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import br.eng.joaovictor.assistant.R
import br.eng.joaovictor.assistant.feature.home.presentation.theme.AssistantTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun AddEditTaskScreen(
    navController: NavController,
    viewModel: AddEditTaskViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    AssistantTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Transparent),
                    title = {},
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Voltar"
                            )
                        }
                    }
                )
            },
            content = {
                Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                Modifier
                    .width((width * 1.5).dp)
                    .offset(y = (-60).dp)
                    .wrapContentSize(unbounded = true)
            ) {
                CreateIcon(true)
            }
            Row() {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(top = 16.dp),
                    ) {
                    Text(
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                        text = "Vamos começar a planejar?",
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        text = "Primeiro você precisa decidir se isso é um hábito, uma tarefa recorrente ou uma tarefa de instância única.",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                    )
                }
            }
            LazyRow(
                Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                item {
                    ElevatedSuggestionChip(
                        onClick = { /*TODO*/ },
                        label = { Text("Hábito", color = MaterialTheme.colorScheme.surfaceTint) },
                        interactionSource = remember { MutableInteractionSource() },
                        enabled = false

                    )
                }
                item {
                    ElevatedSuggestionChip(
                        onClick = { /*TODO*/ },
                        label = { Text("Tarefa Recorrente", color = MaterialTheme.colorScheme.surfaceTint) },
                        interactionSource = remember { MutableInteractionSource() },
                        )
                }
                item {
                    ElevatedSuggestionChip(
                        onClick = { /*TODO*/ },
                        label = { Text("Tarefa", color = MaterialTheme.colorScheme.surfaceTint) },
                        interactionSource = remember { MutableInteractionSource() },
                        )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(.9f),
                    label = { Text("Título") },
                    placeholder = { Text("Dê um nome a sua tarefa") },
                    value = state.title,
                    onValueChange = { viewModel.onEvent(AddEditTaskEvent.OnTaskTitleChanged(it)) })
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp, bottom = 5.dp)
                    .weight(1f, false),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer),
                    content = { Text("CANCELAR")
                })
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer),
                    content = { Text("CONTINUAR")
                    }

                )

            }

        }

        })
    }
}

@Composable
fun CreateIcon(isLarge : Boolean = false) {
    val colors = listOf(MaterialTheme.colorScheme.onPrimary, MaterialTheme.colorScheme.primaryContainer)
    val painter = painterResource(id = R.drawable.ic_add_task)
    val scaleImg = if (isLarge) 0.99f else .5f
    val heightImgScale = if (isLarge) 30f else .20f
    val widthImgScale = if (isLarge) 40f else .6f
    val drawSize = if (isLarge) 400.dp else 180.dp
    val imgColor = MaterialTheme.colorScheme.onPrimaryContainer

    Canvas(
        modifier = Modifier
            .size(drawSize)) {
        rotate(degrees = 45f){
        drawOval(
            size = Size(
                width = drawSize.toPx(),
                height = drawSize.toPx()*1.3f - 50.dp.toPx()
            ),
            topLeft = Offset(
                x = 50.dp.toPx(),
                y = 0.dp.toPx()
            ),
            brush = Brush.linearGradient(colors = colors)

        )
        }
            with(painter) {
                scale(scale = scaleImg, pivot = Offset(size.width * widthImgScale, size.height * heightImgScale)) {
                draw(size = painter.intrinsicSize,
                    alpha = 1f,
                    colorFilter = ColorFilter.tint(imgColor))
            }
        }

    }
}