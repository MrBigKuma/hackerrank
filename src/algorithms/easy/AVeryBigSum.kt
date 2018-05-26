package algorithms.easy

import java.util.*

/*
 * Complete the algorithms.easy.aVeryBigSum function below.
 */
fun aVeryBigSum(n: Int, ar: Array<Long>): Long {
	/*
	 * Write your code here.
	 */
	return ar.sum()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val ar = scan.nextLine().split(" ").map{ it.trim().toLong() }.toTypedArray()

	val result = aVeryBigSum(n, ar)

	println(result)
}
