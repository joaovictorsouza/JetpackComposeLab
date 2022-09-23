package br.eng.joaovictor.assistant.data.datasource.util

import androidx.room.TypeConverter
import br.eng.joaovictor.assistant.data.datasource.enums.TaskTypeEnum

class TaskTypeConverters {

    @TypeConverter
    fun toTaskType(value: Int) = enumValues<TaskTypeEnum>()[value]

    @TypeConverter
    fun fromTaskType(value: TaskTypeEnum) = value.ordinal
}