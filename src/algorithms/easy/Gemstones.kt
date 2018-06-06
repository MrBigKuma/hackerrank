package algorithms.easy

import java.util.*

// Complete the gemstones function below.
fun gemstones(arr: Array<String>): Int {
	return arr.map { it.toCharArray().toSet() }
			.reduceIndexed { index, acc, set -> if (index == 0) set else acc.intersect(set) }
			.size
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val arr = Array<String>(n, { "" })
	for (i in 0 until n) {
		val arrItem = scan.nextLine()
		arr[i] = arrItem
	}

	val result = gemstones(arr)

	println(result)
}

