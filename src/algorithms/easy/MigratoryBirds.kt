package algorithms.easy

import java.util.*

// Complete the migratoryBirds function below.
fun migratoryBirds(ar: Array<Int>): Int {
	val countMap = mutableMapOf<Int, Int>()

	ar.forEach {
		countMap.compute(it, { k, v -> v?.let { v + 1 } ?: 1 })
	}

	// id <= 5
	return countMap.maxBy { (id, count) -> count * 10 - id }!!.key
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val arCount = scan.nextLine().trim().toInt()

	val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = migratoryBirds(ar)

	println(result)
}


