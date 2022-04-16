package io.github.brucefreedy.mccommand.api.context

import io.github.brucefreedy.mccommand.api.tree.ArgumentCommandNode

class ParsedArgument<S>(val name: String, val node: ArgumentCommandNode<S>)
