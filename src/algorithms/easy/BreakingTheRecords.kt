package algorithms.easy


import java.util.*

// Complete the breakingRecords function below.
fun breakingRecords(score: Array<Int>): Array<Int> {
	var minCount = -1
	var maxCount = -1 // Don't count 1st time
	var minScore = Int.MAX_VALUE
	var maxScore = Int.MIN_VALUE

	score.forEach {
		if (it < minScore) {
			minCount++
			minScore = it
		}

		if (it > maxScore) {
			maxCount++
			maxScore = it
		}
	}

	return arrayOf(maxCount, minCount)
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val score = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = breakingRecords(score)

	println(result.joinToString(" "))
}

