@file:OptIn(ExperimentalMaterial3Api::class)

package br.eng.joaovictor.assistant.presentation.add_edit_task.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.eng.joaovictor.assistant.R
import br.eng.joaovictor.assistant.data.datasource.enums.TaskTypeEnum
import br.eng.joaovictor.assistant.presentation.add_edit_task.AddEditTaskEvent

@Composable
fun TaskTypeSelection(selectedType: TaskTypeEnum, onSelected: (TaskTypeEnum) -> Unit, modifier: Modifier = Modifier) {
    LazyRow(
        Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),

    ) {
        item {
            InputChip(
                selected = selectedType == TaskTypeEnum.TASK,
                onClick = { onSelected(TaskTypeEnum.TASK) },
                label = {
                    Text(
                        stringResource(R.string.chip_task),
                        color = MaterialTheme.colorScheme.surfaceTint
                    )
                },
                interactionSource = remember { MutableInteractionSource() },
            )
        }
        item {
            InputChip(
                selected = selectedType == TaskTypeEnum.HABIT,
                onClick = { onSelected(TaskTypeEnum.HABIT) },
                label = {
                    Text(
                        stringResource(R.string.chip_habit),
                        color = MaterialTheme.colorScheme.surfaceTint
                    )
                },
                interactionSource = remember { MutableInteractionSource() },

                )
        }

    }
}