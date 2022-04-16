package io.github.brucefreedy.mccommand.api.tree

open class CommandNode<S> {
    protected val children: LinkedHashMap<String, ArgumentCommandNode<S>> = LinkedHashMap()

    fun getChild() = children.toMutableMap()

    fun addChild(name: String, commandNode: ArgumentCommandNode<S>) {
        children[name] = commandNode
    }

}
