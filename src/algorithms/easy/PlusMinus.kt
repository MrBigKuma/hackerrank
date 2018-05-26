package algorithms.easy

import java.util.*

// Complete the algorithms.easy.plusMinus function below.
fun plusMinus(arr: Array<Int>): Unit {
	var p = 0.0
	var n = 0.0
	var z = 0.0
	for (v in arr) {
		when {
			(v > 0) -> p++
			(v < 0) -> n++
			else -> z++
		}
	}
	println(p / arr.size)
	println(n / arr.size)
	println(z / arr.size)
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	plusMinus(arr)
}
