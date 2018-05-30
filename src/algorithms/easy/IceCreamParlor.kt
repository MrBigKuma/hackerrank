package algorithms.easy

import java.util.*

// Complete the icecreamParlor function below.
fun icecreamParlor2(m: Int, arr: Array<Int>): Array<Int> {
	val valMap = arr.mapIndexed { index, v -> index to v }
			.groupBy { it.second }

	for (i in 0 until arr.size) {
		valMap[m - arr[i]]?.find { (index, _) -> index != i }
				?.let { (index, _) -> return arrayOf(i + 1, index + 1) }
	}

	return arrayOf()
}

// Complete the icecreamParlor function below.
fun icecreamParlor(m: Int, arr: Array<Int>): Array<Int> {
	for (i in 0 until arr.size) {
		for (j in (i + 1) until arr.size)
			if (arr[i] + arr[j] == m)
				return arrayOf(i + 1, j + 1)
	}

	return arrayOf()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val t = scan.nextLine().trim().toInt()

	for (tItr in 1..t) {
		val m = scan.nextLine().trim().toInt()

		val n = scan.nextLine().trim().toInt()

		val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

		val result = icecreamParlor2(m, arr)

		println(result.joinToString(" "))
	}
}

