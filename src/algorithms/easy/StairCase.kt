package algorithms.easy

import java.util.*

// Complete the algorithms.easy.staircase function below.
fun staircase(n: Int): Unit {
	for (r in 1..n) {
		for (c in 1..n) {
			if (c <= n - r)
				print(" ")
			else
				print("#")
		}
		println()
	}
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	staircase(n)
}
