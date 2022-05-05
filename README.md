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
import io.github.brucefreedy.mccommand.MCCommand
import io.github.brucefreedy.mccommand.player

MCCommand(plugin) {
    command("party") {

        thenExecute("create") { println("You create a new party") }

        then("invite") {
            tab { listOf("Jimmy", "Sam", "Charlie") }

            execute { println("You invited ${args[1]}!") }
        }

    }
    command("show") {
        thenExecute("myname") {
            println(player.name)
        }
    }
}
```

---