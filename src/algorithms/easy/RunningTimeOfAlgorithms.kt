package algorithms.easy

import java.util.*

// Complete the runningTime function below.
fun runningTime(arr: Array<Int>): Int {
	return insertionSort2ShiftCount(arr.size, arr)
}

fun insertionSort2ShiftCount(n: Int, arr: Array<Int>): Int {
	val curArr = arr.copyOf()
	var shiftCount = 0
	for (limit in 1..(n - 1)) {
		val newVal = arr[limit]

		for (i in limit downTo 0) {
			if (i == 0) {
				curArr[0] = newVal
				break
			}

			if (curArr[i - 1] > newVal) {
				curArr[i] = curArr[i - 1]
				shiftCount++
				continue
			}

			curArr[i] = newVal
			break
		}
	}

	return shiftCount
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = runningTime(arr)

	println(result)
}

