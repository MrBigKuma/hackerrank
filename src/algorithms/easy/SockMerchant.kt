package algorithms.easy

import java.util.*

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
	val sockCount = mutableMapOf<Int, Int>()
	ar.forEach {
		sockCount.compute(it, { k, v -> v?.let { v + 1 } ?: 1 })
	}

	return sockCount.values.map { it / 2 }.sum()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = sockMerchant(n, ar)

	println(result)
}
