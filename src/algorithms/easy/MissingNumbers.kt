package algorithms.easy

import java.util.*

// Complete the missingNumbers function below.
fun missingNumbers(arr: Array<Int>, brr: Array<Int>): Array<Int> {
	val countMap = mutableMapOf<Int, Int>()

	arr.forEach {
		countMap.compute(it, { _, v -> v?.let { v + 1 } ?: 1 })
	}
	brr.forEach {
		countMap.compute(it, { _, v -> v?.let { v - 1 } ?: -1 })
	}

	return countMap.filter { (_, v) -> v < 0 }.keys.sorted().toTypedArray()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val m = scan.nextLine().trim().toInt()

	val brr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = missingNumbers(arr, brr)

	println(result.joinToString(" "))
}


