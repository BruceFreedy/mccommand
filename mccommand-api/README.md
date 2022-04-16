# mccommand api

모장의 오픈소스 프로젝트 [brigadier](https://github.com/Mojang/brigadier) 을 모작해서 만듬

---


```kotlin
data class Player(val name: String)

val commandDispatcher = CommandDispatcher<Player> {
    //  "할복" 명령어를 만들어 보고 싶으세요?
    executeCommand("할복") { TODO("할복하기") }
    
    executeCommand("포인트") { println("당신은 /포인트 ${args[0]} 을(를) 입력했음") }

    //source는 <S>의 객체입니다.
    // 이 소스는 현재 진행 중인 명령에 대한 실행부분에서 가져올 수 있습니다
    commandDispatcher.execute("할복", Player("hong gil dong"))

}


```
`/point give 100` 이런 명령어 만들어 보면..

```kotlin

```

---