fun main() {
    fun part1(input: List<Int>): Int {
        return input.windowed(2).count { (a, b) -> a < b }
    }

    fun part2(input: List<Int>): Int {
        return input
            .windowed(3)
            .windowed(2)
            .count { (a, b) ->
                a.sum() < b.sum()
            }
    }

    val input = readInputAsInt("Day01")
    println(part1(input))
    println(part2(input))
}
