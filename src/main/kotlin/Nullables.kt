fun main() {
    val interstellarHouse = House(
        Person("Thomas", null, "Bangalter", "T-Bang"),
        5555.0,
        null,
        Person("Guy-Manuel", null, "de Homem Christo", "G-Man")
    )

    var aboutTheHouse: String

    interstellarHouse.apply {
        val ownerName = owner.let { it.nickname ?: "${it.name} ${it.lastName}"  }
        val tenantName = tenant?.let { it.nickname ?: "${it.name} ${it.secondName}" }

        aboutTheHouse = when (tenant) {
            null -> {
                "$ownerName is the owner of the Interstellar House that once belong to the CrescenDolls"
            }
            else -> {
                rent?.let { rent ->
                        "$tenantName is paying $rent/month to $ownerName for living in the same house that once owned the CrescenDolls"
                } ?:    "$tenantName is living in the $ownerName's house"
            }
        }

        aboutTheHouse += """
            
            This house has an unique value, $${price}
            Do you guess why?
            If you don't know, ask to $ownerName, it's really an interesting person
        """.trimIndent()
    }

    println(aboutTheHouse)
}

class House (
    val owner: Person,
    val price: Double,
    val rent: Double?,
    val tenant: Person?
)

class Person(
    val name: String,
    val secondName: String?,
    val lastName: String,
    val nickname: String?
)