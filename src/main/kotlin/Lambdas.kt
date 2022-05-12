fun main() {
    val functionType: () -> String = {
        "This is a anonymous function"
    }

    println(functionType())

    val greetingFunction: (String) -> String = { name ->
        "Hello $name, it's a good day to code"
    }

    println(greetingFunction(readln()))

    val secondGreeting: (String) -> String = {
        "Hello again $it, so you decided to try another"
    }

    println(secondGreeting(readln()))

    val thirdGreeting = { name: String ->
        "Okay, enough it's enough, good bye $name"
    }

    println(thirdGreeting(readln()))

    val helloToEverybody = { names: String, cities: String ->
        val citiesList = cities.split('/')
        names.split(',').forEach {
            println("Hello $it, from ${citiesList.shuffled().first()}")
        }
    }

    helloToEverybody(readln(), readln())

    someStoryFunction("Maliachi", greetingFunction)
    someStoryFunction("Rodrigo", {"Sup $it, beautiful night"})
    someStoryFunction("MF", ::anotherHiFunction)
    someStoryFunction("Freddie Mercury") { fredy ->
        "OMG! it's really $fredy? I CAN'T BELIEVE IT"
    }
}

fun anotherHiFunction(name: String) = "HOW MANY TIMES I'LL SAY HI TO U $name?"

inline fun someStoryFunction(name: String, sayingHiFunction: (String) -> String) {
    var someStory = """ 
        Cold was the night, the moon was bright and the wind was about to tell
        us the next words: 
    """.trimIndent()
    someStory += sayingHiFunction(name)

    println(someStory)
}