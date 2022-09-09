package br.eng.joaovictor.assistant.data.datasource.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey val uid : Int,
    @ColumnInfo(name = "description") val description: String
)