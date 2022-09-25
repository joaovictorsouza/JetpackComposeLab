package br.eng.joaovictor.assistant.presentation.add_edit_task.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.eng.joaovictor.assistant.R

@Composable
fun AddTaskHeader(title : String, description : String, modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp

    Row {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = Modifier.padding(start = 26.dp, end = 26.dp),
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )
        }
    }
}


@Composable
fun CreateIcon(isLarge: Boolean = false) {
    val colors =
        listOf(MaterialTheme.colorScheme.onPrimary, MaterialTheme.colorScheme.primaryContainer)
    val painter = painterResource(id = R.drawable.ic_add_task)
    val scaleImg = if (isLarge) 0.99f else .5f
    val heightImgScale = if (isLarge) 30f else .20f
    val widthImgScale = if (isLarge) 40f else .6f
    val drawSize = if (isLarge) 400.dp else 180.dp
    val imgColor = MaterialTheme.colorScheme.onPrimaryContainer

    Canvas(
        modifier = Modifier
            .size(drawSize)
    ) {
        rotate(degrees = 45f) {
            drawOval(
                size = Size(
                    width = drawSize.toPx(),
                    height = drawSize.toPx() * 1.3f - 50.dp.toPx()
                ),
                topLeft = Offset(
                    x = 50.dp.toPx(),
                    y = 0.dp.toPx()
                ),
                brush = Brush.linearGradient(colors = colors)

            )
        }
        with(painter) {
            scale(
                scale = scaleImg,
                pivot = Offset(size.width * widthImgScale, size.height * heightImgScale)
            ) {
                draw(
                    size = painter.intrinsicSize,
                    alpha = 1f,
                    colorFilter = ColorFilter.tint(imgColor)
                )
            }
        }

    }
}