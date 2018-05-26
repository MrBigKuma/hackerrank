package algorithms.medium

import java.math.BigInteger
import java.util.*

// Complete the extraLongFactorials function below.
fun extraLongFactorials(n: Int): Unit {
	var total : BigInteger = BigInteger.ONE
	for (i in 1..n) {
		total = total.multiply(BigInteger.valueOf(i.toLong()))
	}

	print(total.toString())
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	extraLongFactorials(n)
}


