package algorithms.easy

import java.util.*
import kotlin.math.min

// Complete the jumpingOnClouds function below.
fun jumpingOnClouds(c: Array<Int>): Int {
	return minJump(c, 0) - 1
}

fun minJump(arr: Array<Int>, startIndex: Int): Int {
	if (startIndex == (arr.size - 1))
		return 1

	if (startIndex >= arr.size)
		return Int.MAX_VALUE

	if (arr[startIndex] == 1)
		return Int.MAX_VALUE

	return 1 + min(minJump(arr, startIndex + 1), minJump(arr, startIndex + 2))
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = jumpingOnClouds(c)

	println(result)
}
