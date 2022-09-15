package br.eng.joaovictor.assistant.presentation.home

sealed class HomeEvent {
    data class OnClick(val id: Int) : HomeEvent()
}