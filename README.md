# mccommand


```kotlin
data class Player(val name: String)

//...

val commandDispatcher = CommandDispatcher<Player> {
    //  "할복" 명령어를 만들어 보고 싶으세요?
    executeCommand("할복") { TODO("할복하기") }
    
    executeCommand("포인트") { println("당신은 /포인트 ${args[0]} 을(를) 입력했음") }

}

commandDispatcher.execute("할복", Player("hong gil dong"))

```

---