package br.eng.joaovictor.assistant.di.domain.util

import br.eng.joaovictor.assistant.core.util.UiText

class InvalidTaskException(val resourceMessage: UiText.StringResource) : Throwable()
