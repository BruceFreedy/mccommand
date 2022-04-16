package io.github.brucefreedy.mccommand.api

import io.github.brucefreedy.mccommand.api.tree.RootCommandNode

open class CommandDispatcher<S>(init: RootCommandNode<S>.() -> Unit) {

    protected val root = RootCommandNode<S>()
    init { init(root) }

    fun execute(command: String, source: S) {
        root.execute(root.parse(command, source))
    }

    fun tab(command: String, source: S) = root.tab(root.parse(command, source))

}