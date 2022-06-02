@file:Suppress("unused")

fun main() {
    val percy = DemiGod("Percy Jackson", God.Poseidon, Gender.MALE, Weapon.Sword)

    percy.apply {
        setAbilities.apply {
            add("Leader")
            add("Great brother")
            add("Horse speaking")
        }
        spelling["a"] = "4"
        spelling["e"] = "3"
        spelling["u"] = "v"

        presentation()
            .run(::changeWayOfSpeak)
            .run(::println)
    }.also {
        println(it)
    }
}

enum class God {
    Zeus,
    Poseidon,
    Hades,
    Hera,
    Hermes,
    Ares,
    Atenea,
    Artemisa,
    Afrodita,
    Apolo,
    Hefesto,
    Demeter;

    fun mapToGodOf(god: God) = "I $god, " +
        when (god) {
            Zeus -> "god of thunders"
            Poseidon -> "god of the sea"
            Hades -> "god of the underworld"
            Hera -> "goddess of women and marriage"
            Hermes -> "god of the thieves and messengers"
            Ares -> "god of war"
            Atenea -> "goddess of justice and war"
            Artemisa -> "goddess of hunting and wildlife"
            Afrodita -> "goddess of love and beauty"
            Apolo -> "the sun and poetry"
            Hefesto -> "god of the forges"
            Demeter -> "goddess of the agriculture"
        }
}
enum class Weapon {
    Sword,
    Bow,
    MagicBook,
    Melee,
}
enum class Gender { FEMALE, MALE }

class DemiGod(
    val name: String,
    val god: God?,
    val gender: Gender,
    var weapon: Weapon
) {
    val setAbilities = mutableSetOf<String>()
    val spelling = mutableMapOf<String, String>()

    fun presentation(): String {
        var presentation = ""
        presentation += "I'm $name, "
        presentation += god?.let { god ->
                    if (gender == Gender.FEMALE)
                        "daughter of $god. "
                    else
                        "son of $god. "
        } ?: "member of Hermes' cabin. "
        presentation += "Face my $weapon if you dare"
        return presentation
    }

    inline fun presentation(funPresentation: (String, God?, Gender, Weapon) -> String) = funPresentation(name, god, gender, weapon)

    fun changeWayOfSpeak(phrase: String) =
        phrase.replace(Regex("[aeiou]")) {
            spelling.getOrDefault(it.value, it.value)
        }

    override fun toString(): String {
        return presentation()
    }
}