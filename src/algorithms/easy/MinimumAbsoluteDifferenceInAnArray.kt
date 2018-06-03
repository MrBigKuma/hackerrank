package algorithms.easy

import java.util.*
import kotlin.math.absoluteValue

// Complete the minimumAbsoluteDifference function below.
fun minimumAbsoluteDifference(n: Int, arr: Array<Int>): Int {
	val sortedArr = arr.sortedArray()
	return (0 until sortedArr.lastIndex).map {
		(sortedArr[it] - sortedArr[it + 1]).absoluteValue
	}.min()!!
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = minimumAbsoluteDifference(n, arr)

	println(result)
}


