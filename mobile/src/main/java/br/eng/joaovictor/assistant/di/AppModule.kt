package br.eng.joaovictor.assistant.di

import android.app.Application
import androidx.room.Room
import br.eng.joaovictor.assistant.data.datasource.AssistantDb
import br.eng.joaovictor.assistant.data.repository.TaskRepositoryImpl
import br.eng.joaovictor.assistant.di.domain.repository.TaskRepository
import br.eng.joaovictor.assistant.di.domain.use_case.task.AddTask
import br.eng.joaovictor.assistant.di.domain.use_case.task.GetAllTasks
import br.eng.joaovictor.assistant.di.domain.use_case.task.TaskUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : AssistantDb {
        return Room.databaseBuilder(
            app,
            AssistantDb::class.java,
            AssistantDb.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(db: AssistantDb) : TaskRepository {
        return TaskRepositoryImpl(db.taskDao)
    }

    @Provides
    @Singleton
    fun provideTaskUseCases(repository: TaskRepository) : TaskUseCases {
        return TaskUseCases(
            getAllTasks = GetAllTasks(repository),
            addTask = AddTask(repository)
        )
    }

}