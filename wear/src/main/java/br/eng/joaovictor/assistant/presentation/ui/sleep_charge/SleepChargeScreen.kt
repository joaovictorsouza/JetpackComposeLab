package br.eng.joaovictor.assistant.presentation.ui.sleep_charge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.rememberScalingLazyListState
import br.eng.joaovictor.assistant.presentation.components.FeatureChip

@Composable
fun SleepChargeScreen(){
    val listState = rememberScalingLazyListState()

    ScalingLazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            top = 32.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 32.dp
        ),
        verticalArrangement = Arrangement.Center,
        state = listState
    ){
        item { FeatureChip(title = "Carga p/ Noite", description = "Status de carregamento para noite", onClickParams = {}) }
    }
    }
