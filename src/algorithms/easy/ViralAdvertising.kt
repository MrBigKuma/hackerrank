package algorithms.easy

import java.util.*

// Complete the viralAdvertising function below.
fun viralAdvertising(n: Int): Int {
	var total = 0
	var shared = 5
	(0 until n).forEach {
		total += shared / 2
		shared = (shared / 2) * 3
	}

	return total
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val result = viralAdvertising(n)

	println(result)
}


