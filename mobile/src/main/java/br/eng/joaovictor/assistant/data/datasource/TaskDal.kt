package br.eng.joaovictor.assistant.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.eng.joaovictor.assistant.data.datasource.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM Task")
    fun getAll() : Flow<List<Task>>

    @Insert
    fun insertAll(vararg tasks: Task)
}
