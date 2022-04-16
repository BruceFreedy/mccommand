package io.github.brucefreedy.mccommand.api.tree

import io.github.brucefreedy.mccommand.api.context.CommandContext
import io.github.brucefreedy.mccommand.api.context.CommandContextBuilder
import io.github.brucefreedy.mccommand.api.context.ParsedArgument

open class ArgumentCommandNode<S> : CommandNode<S>() {
    val defTab get() = getChild().keys.toTypedArray()
    var tab: CommandContext<S>.() -> Collection<String> = { getChild().keys }
    var execute: CommandContext<S>.() -> Unit = {}

    fun then(vararg arg: String, init: ArgumentCommandNode<S>.() -> Unit) {
        val node = ArgumentCommandNode<S>().apply(init)
        arg.forEach { addChild(it, node) }
    }

    fun executeThen(vararg arg: String, init: CommandContext<S>.() -> Unit) = then(*arg) { execute(init) }

    fun execute(init: CommandContext<S>.() -> Unit) {
        execute = init
    }

    fun tab(init: CommandContext<S>.() -> Collection<String>) {
        tab = init
    }

    open fun parse(context: CommandContextBuilder<S>) {
        val argument = context.command.substring(context.reader.cursor)
        val trimCount = argument.run { indices.firstOrNull { index -> !Character.isWhitespace(this[index]) } }?: 0
        val trimmedArgument = argument.subSequence(trimCount, argument.length).toString()
        children.filterKeys { trimmedArgument.startsWith(it, ignoreCase = true) }.entries.firstOrNull()?.apply {
            context.reader.cursor += key.length + trimCount
            context.argument.add(ParsedArgument(key, value))
            value.parse(context)
        }?: context.argument.add(ParsedArgument(trimmedArgument.trimEnd(), EmptyNode()))
    }

}