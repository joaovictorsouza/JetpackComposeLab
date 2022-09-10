package br.eng.joaovictor.assistant.domain.use_case.task

import br.eng.joaovictor.assistant.data.datasource.model.Task
import br.eng.joaovictor.assistant.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetAllTasks(
    private val repository: TaskRepository
) {
    operator fun invoke(): Flow<List<Task>> {
        return repository.getAllTasks()
    }
}