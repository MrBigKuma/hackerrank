package algorithms.easy

import java.util.*

// Complete the flippingBits function below.
fun flippingBits(N: Long): Long {
	return 4294967295 - N // 2^32 -1 - N

}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val T = scan.nextLine().trim().toInt()

	for (TItr in 1..T) {
		val N = scan.nextLine().trim().toLong()

		val result = flippingBits(N)

		println(result)
	}
}


