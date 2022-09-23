package br.eng.joaovictor.assistant.data.datasource.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import br.eng.joaovictor.assistant.data.datasource.enums.TaskTypeEnum
import br.eng.joaovictor.assistant.data.datasource.util.TaskTypeConverters

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val uid : Int,

    @ColumnInfo(name = "title")
    val title: String,

    @TypeConverters(TaskTypeConverters::class)
    @ColumnInfo(name = "type")
    val type: TaskTypeEnum,

    @ColumnInfo(name = "created_at")
    var createdAt: Long,

    @ColumnInfo(name = "updated_at")
    var updatedAt: Long

)