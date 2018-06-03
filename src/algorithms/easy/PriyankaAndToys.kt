package algorithms.easy


import java.util.*

// Complete the toys function below.
fun toys(weights: Array<Int>): Int {
	val sortedWeights = weights.sortedArray()

	var containerCount = 0
	var curItemInContainerCount = 0
	var curMinWeightInContainer = Integer.MAX_VALUE
	for (w in sortedWeights) {
		if (curMinWeightInContainer < w - 4)
			curItemInContainerCount = 0

		if (curItemInContainerCount == 0) {
			containerCount++
			curMinWeightInContainer = w
		}

		curItemInContainerCount++
	}

	return containerCount
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val w = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = toys(w)

	println(result)
}

