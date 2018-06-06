package algorithms.easy

import java.util.*

// Complete the closestNumbers function below.
fun closestNumbers(arr: Array<Int>): Array<Int> {
	val sortedArr = arr.sortedArray()
	var min = Integer.MAX_VALUE
	val minPairs = mutableListOf<Int>()
	(0 until sortedArr.lastIndex).forEach {
		val diff = sortedArr[it + 1] - sortedArr[it]
		if (diff < min) {
			min = diff
			minPairs.clear()
		}

		if (diff == min) {
			minPairs.add(sortedArr[it])
			minPairs.add(sortedArr[it + 1])
		}
	}

	return minPairs.toTypedArray()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = closestNumbers(arr)

	println(result.joinToString(" "))
}


