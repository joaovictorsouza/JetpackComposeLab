package br.eng.joaovictor.assistant.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import br.eng.joaovictor.assistant.data.datasource.model.Task

@Database(entities = [Task::class], version = 1)
abstract class  AssistantDb : RoomDatabase(){
    abstract fun taskDao(): TaskDao
}