import io.github.brucefreedy.mccommand.api.CommandDispatcher

fun main() {
    val commandDispatcher =
        CommandDispatcher<Any> {
            command("killall") {
                execute { println("Usage: /killall [zombie, boss, slime]") }
                executeThen("zombie") { println("whole zombie killed!") }
                then("boss") {
                    val bosses = arrayOf("dragon", "wither", "golem")
                    execute { println("Usage: /killall boss [${bosses.joinToString(", ")}]") }
                    executeThen(*bosses) { println("whole ${args[1]} boss killed!") }
                    tab { listOf(*bosses) }
                }
                executeThen("slime") {  println("whole slime crushed!") }
            }
        }
    fun execute(command: String) = commandDispatcher.execute(command, Any())

    execute("killall")
    execute("killall zombie")
    execute("killall boss")
    execute("killall boss dragon")
    execute("killall slime")
    execute("killall slime")
}