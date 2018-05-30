package algorithms.easy

import java.util.*

// Complete the divisibleSumPairs function below.
fun divisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
	return (0 until ar.size - 1).sumBy { i ->
		(i + 1 until ar.size).count { j ->
			(ar[i] + ar[j]) % k == 0
		}
	}
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nk = scan.nextLine().split(" ")

	val n = nk[0].trim().toInt()

	val k = nk[1].trim().toInt()

	val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = divisibleSumPairs(n, k, ar)

	println(result)
}


