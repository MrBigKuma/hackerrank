package algorithms.easy

import java.util.*

// Complete the minimumDistances function below.
fun minimumDistances(A: Array<Int>): Int {
	val firstIndexMap = mutableMapOf<Int, Int>()
	val minDistMap = mutableMapOf<Int, Int>()
	(0 until A.size).forEach { index ->
		val a = A[index]
		if (firstIndexMap.containsKey(a))
			minDistMap[a] = index - firstIndexMap[a]!!
		else
			firstIndexMap.putIfAbsent(a, index)
	}

	return minDistMap.values.min() ?: -1
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = minimumDistances(a)

	println(result)
}


