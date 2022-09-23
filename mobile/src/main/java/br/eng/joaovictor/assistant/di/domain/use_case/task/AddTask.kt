package br.eng.joaovictor.assistant.di.domain.use_case.task

import br.eng.joaovictor.assistant.R
import br.eng.joaovictor.assistant.core.util.UiText
import br.eng.joaovictor.assistant.data.datasource.model.Task
import br.eng.joaovictor.assistant.di.domain.repository.TaskRepository
import br.eng.joaovictor.assistant.di.domain.util.InvalidTaskException

class AddTask(
    private val repository: TaskRepository
) {

    suspend operator fun invoke(task: Task) {

        if(task.title.isBlank()) {

            throw InvalidTaskException(
                UiText.StringResource(
                    resId = R.string.add_task_empty_title_error,
            ))
        }


        task.createdAt = System.currentTimeMillis()
        task.updatedAt = System.currentTimeMillis()

        return repository.addTask(task)
    }
}