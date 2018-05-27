package algorithms.easy

import java.util.*

// Complete the equalizeArray function below.
fun equalizeArray(arr: Array<Int>): Int {
	val countMap = mutableMapOf<Int, Int>()
	arr.forEach {
		countMap.compute(it, { _, v -> v?.let { v + 1 } ?: 1 })
	}

	return arr.size - countMap.values.max()!!
}

fun equalizeArraySol1(arr: Array<Int>): Int {
	val maxEqualValCount = arr.groupBy { it }
			.map { (_, v) -> v.count() }
			.max()!!

	return arr.size - maxEqualValCount
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = equalizeArray(arr)

	println(result)
}


