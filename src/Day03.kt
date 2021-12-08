fun main() {
    fun part1(input: List<String>): Int {
        val columns = input[0].indices
        val gammaRate = buildString {
            for (column in columns) {
                val (zeros, ones) = input.countBitsInColumn(column)
                val commonBit = if (zeros > ones) "0" else "1"
                append(commonBit)
            }
        }

        val epsilonRate = gammaRate.invertBinaryString()
        println("Gamma: $gammaRate Epsiolon: $epsilonRate")
         println("Gamma: ${gammaRate.toInt(2)} Epsiolon: ${epsilonRate.toInt(2)}")

        return gammaRate.toInt(2) * epsilonRate.toInt(2)
    }

    fun part2(input: List<String>): Int {
        fun rating(ratingType: RatingType): String {
            val columns = input[0].indices
            var candidates = input

            for (column in columns) {
                val (zeroes, ones) = candidates.countBitsInColumn(column)
                val mostCommon = if (zeroes > ones) '0' else '1'
                candidates = candidates.filter {
                    when(ratingType) {
                        RatingType.OXYGEN -> it[column] == mostCommon
                        RatingType.CO2 -> it[column] != mostCommon
                    }

                }
                if (candidates.size == 1) break
            }
            return candidates.single()
        }

        return rating(RatingType.OXYGEN).toInt(2) * rating(RatingType.CO2).toInt(2)
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

private enum class RatingType {
    OXYGEN,
    CO2
}

private fun String.invertBinaryString() = this
    .asIterable()
    .joinToString("") { if (it == '0') "1" else "0" }

private fun List<String>.countBitsInColumn(column: Int): BitCount {
    var zeros = 0
    var ones = 0

    for (line in this) {
        if (line[column] == '0')
            zeros++
        else ones++
    }

    return BitCount(zeros, ones)
}

data class BitCount(val zeros: Int, val ones: Int)