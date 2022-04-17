# mccommand

# Import 

```gradle
repositories {
    maven("https://s01.oss.sonatype.org/content/repositories/releases")
}

dependencies {
    implementation("io.github.brucefreedy:mccommand:1.0.1")
}
```

# Examples

```kotlin
data class Player(val name: String)

//...

val commandDispatcher = CommandDispatcher<Player> {
    executeCommand("selfkill") { TODO("selfkill") }
    
    executeCommand("point") { println("you execute /point ${args[0]} command") }

}

commandDispatcher.execute("selfkill", Player("hong gil dong"))
commandDispatcher.execute("point 100", Player(""))

```

---