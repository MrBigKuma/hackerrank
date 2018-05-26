package algorithms.easy

import java.util.*

// Complete the algorithms.easy.miniMaxSum function below.
fun miniMaxSum(arr: Array<Int>): Unit {
	val sum = arr.map { it.toLong() }.sum()
	print("${sum - arr.max()!!.toLong()} ${sum - arr.min()!!.toLong()}")
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	miniMaxSum(arr)
}
