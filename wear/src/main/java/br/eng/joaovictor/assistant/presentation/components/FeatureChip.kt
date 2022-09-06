package br.eng.joaovictor.assistant.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.wear.compose.material.*


@Composable
fun FeatureChip(title: String, description : String, onClickParams: () -> Unit){
    TitleCard(
        title = {
                Text(
                    text = title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis)
                },
        onClick = onClickParams
    )
         {
             Text(
                text = description,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
             )
        }
}