@file:OptIn(ExperimentalMaterialApi::class)

package br.eng.joaovictor.assistant.presentation.task_list.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.eng.joaovictor.assistant.data.datasource.enums.TaskTypeEnum
import br.eng.joaovictor.assistant.data.datasource.model.Task

@Composable
fun TaskItem(taskItem : Task, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Surface(
            color = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
            tonalElevation = 1.dp
        ) {
            ListItem(
                text = { Text(text = taskItem.title, color = MaterialTheme.colorScheme.onSurface) },
                secondaryText = { Text(text =  when(taskItem.type) {
                    TaskTypeEnum.TASK -> "Tarefa"
                    TaskTypeEnum.HABIT -> "Hábito" },
                    color = MaterialTheme.colorScheme.onSurface) },
                icon = { Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "check", tint = MaterialTheme.colorScheme.onSurface ) },

                )
        }
        Divider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.onSurface,
            thickness = Dp.Hairline)
    }
}
