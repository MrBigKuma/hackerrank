package algorithms.easy

import java.util.*

// Complete the jumpingOnClouds function below.
fun jumpingOnClouds(c: Array<Int>, k: Int): Int {
	var index = 0
	var e = 100
	do {
		index = (index + k) % c.size
		e -= 1 + 2 * c[index]
	} while (index != 0)

	return e
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nk = scan.nextLine().split(" ")

	val n = nk[0].trim().toInt()

	val k = nk[1].trim().toInt()

	val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = jumpingOnClouds(c, k)

	println(result)
}


