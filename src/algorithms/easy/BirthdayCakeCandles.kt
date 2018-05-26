package algorithms.easy

import java.util.*

// Complete the birthdayCakeCandles function below.
fun birthdayCakeCandles(ar: Array<Int>): Int {
	var curMax = 0
	var maxCount = 0
	for (v in ar) {
		if (curMax == v)
			maxCount += 1

		if (curMax < v) {
			curMax = v
			maxCount = 1
		}
	}
	return maxCount
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val arCount = scan.nextLine().trim().toInt()

	val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = birthdayCakeCandles(ar)

	println(result)
}
