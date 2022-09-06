package br.eng.joaovictor.assistant.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import br.eng.joaovictor.assistant.presentation.components.FeatureChip

@Composable
fun HomeScreen(onClickParams: () -> Unit){
    val listState = rememberScalingLazyListState()


    Scaffold(
        timeText = { TimeText() },
        vignette = { Vignette(vignettePosition = VignettePosition.TopAndBottom) },
        content = { ListFunctions(listState = listState, onClickParams = onClickParams) },
        positionIndicator = { PositionIndicator(scalingLazyListState = listState) }
    )
}

@Composable
fun ListFunctions(listState: ScalingLazyListState, onClickParams: () -> Unit){
    ScalingLazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            top = 32.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 32.dp
        ),

        verticalArrangement = Arrangement.spacedBy(space = 6.dp),
        state = listState
    ){
        item { FeatureChip(title = "Carga p/ Noite", description = "Status de carregamento para noite", onClickParams = onClickParams) }
        item { FeatureChip(title = "Carga p/ Noite", description = "Status de carregamento para noite", onClickParams = onClickParams) }
        item { FeatureChip(title = "Carga p/ Noite", description = "Status de carregamento para noite", onClickParams = onClickParams) }
        item { FeatureChip(title = "Carga p/ Noite", description = "Status de carregamento para noite", onClickParams = onClickParams) }
        item { FeatureChip(title = "Carga p/ Noite", description = "Status de carregamento para noite", onClickParams = onClickParams) }
        item { FeatureChip(title = "Carga p/ Noite", description = "Status de carregamento para noite", onClickParams = onClickParams) }
    }
}