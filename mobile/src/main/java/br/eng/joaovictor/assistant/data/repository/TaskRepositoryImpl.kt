package br.eng.joaovictor.assistant.data.repository

import br.eng.joaovictor.assistant.data.datasource.TaskDao
import br.eng.joaovictor.assistant.data.datasource.model.Task
import br.eng.joaovictor.assistant.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    private val dao : TaskDao
) : TaskRepository {
    override fun getAllTasks(): Flow<List<Task>> {
        return dao.getAll()
    }
}