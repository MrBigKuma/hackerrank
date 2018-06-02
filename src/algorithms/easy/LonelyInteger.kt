package algorithms.easy

import java.util.*

// Complete the lonelyinteger function below.
fun lonelyinteger(a: Array<Int>): Int {
	val countMap = mutableMapOf<Int, Boolean>()

	a.forEach {
		countMap.compute(it, { _, v -> v?.let { false } ?: true })
	}

	return countMap.entries.find { (_, v) -> v }!!.key
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = lonelyinteger(a)

	println(result)
}


