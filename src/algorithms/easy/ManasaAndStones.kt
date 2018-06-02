package algorithms.easy

import java.util.*

// Complete the stones function below.
fun stones(n: Int, a: Int, b: Int): Array<Int> {
	return (0 until n).map {
		a * it + b * (n - 1 - it)
	}.toSet().sorted().toTypedArray()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val T = scan.nextLine().trim().toInt()

	for (TItr in 1..T) {
		val n = scan.nextLine().trim().toInt()

		val a = scan.nextLine().trim().toInt()

		val b = scan.nextLine().trim().toInt()

		val result = stones(n, a, b)

		println(result.joinToString(" "))
	}
}


