fun main() {
    val readValue = readln()
    val isDigit = readValue.matches( Regex("\\d+") )
    val number = if ( isDigit ) readValue.toInt() else 0

    println("El $number° de la secuencia de fibonacci es: ${fibonacciNumber(number)}")
}

fun fibonacciNumber(number: Int): Int =
    when (number) {
        in (3..50) -> fibonacciNumber(number - 1) + fibonacciNumber(number - 2)
        2 -> 1
        else -> 0
    }