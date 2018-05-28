package algorithms.easy

import java.util.*

// Complete the cutTheSticks function below.
fun cutTheSticks(arr: Array<Int>): Array<Int> {
	val valGroups = arr.groupBy { it }
			.map { (k, v) -> k to v.count() }
			.sortedBy { it.first }

	var remainCount = arr.size
	val cutCounts = Array(valGroups.size, { 0 })
	for (i in 0 until valGroups.size) {
		cutCounts[i] = remainCount
		remainCount -= valGroups[i].second
	}

	return cutCounts
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = cutTheSticks(arr)

	println(result.joinToString("\n"))
}


