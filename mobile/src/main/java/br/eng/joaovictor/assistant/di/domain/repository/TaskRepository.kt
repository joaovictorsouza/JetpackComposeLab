package br.eng.joaovictor.assistant.di.domain.repository

import br.eng.joaovictor.assistant.data.datasource.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTasks() : Flow<List<Task>>
    suspend fun addTask(task: Task)
}