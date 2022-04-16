package io.github.brucefreedy.mccommand.api.context

import io.github.brucefreedy.mccommand.api.StringReader

class CommandContextBuilder<S>(source: S, command: String) : CommandContext<S>(source, command) {
    val reader = StringReader()
}
