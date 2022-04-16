package io.github.brucefreedy.mccommand.api.tree

import io.github.brucefreedy.mccommand.api.context.CommandContextBuilder

class EmptyNode<S> : ArgumentCommandNode<S>() {
    override fun parse(context: CommandContextBuilder<S>) = Unit
}