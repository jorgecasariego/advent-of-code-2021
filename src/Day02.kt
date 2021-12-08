fun main() {
    fun part1(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0

        val operations =  input.map { it.split(' ') }

        for ((direction, amountString) in operations) {
            val amount = amountString.toInt()

            when(direction) {
                "forward" -> horizontalPosition += amount
                "down" -> depth += amount
                "up" -> depth -= amount
            }
        }

        return horizontalPosition * depth
    }

    fun part2(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        var aim = 0

        val operations =  input.map { it.split(' ') }

        for ((direction, amountString) in operations) {
            val amount = amountString.toInt()

            when(direction) {
                "forward" -> {
                    horizontalPosition += amount
                    depth += amount * aim
                }
                "down" -> aim += amount
                "up" -> aim -= amount
            }
        }

        return horizontalPosition * depth
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}