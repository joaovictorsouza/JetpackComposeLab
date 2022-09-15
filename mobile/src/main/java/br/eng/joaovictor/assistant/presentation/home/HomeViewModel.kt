package br.eng.joaovictor.assistant.presentation.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import br.eng.joaovictor.assistant.domain.use_case.task.TaskUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

   fun onEvent(event: HomeEvent) {
       when (event) {
           is HomeEvent.OnClick -> {

           }
       }
   }
}