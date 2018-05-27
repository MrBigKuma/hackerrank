package algorithms.easy

import java.util.*

private fun compareCount(arr: Array<Int>) {
	val qsCount = quickSortInPlaceCount(arr.copyOf(), 0, arr.lastIndex)
	val isCount = insertionSort2ShiftCountWithQuicksort(arr.size, arr)
	println(isCount - qsCount)
}

// Complete the quickSort function below.
fun quickSortInPlaceCount(arr: Array<Int>, sIndex: Int, eIndex: Int): Int {
	if (sIndex >= eIndex)
		return 0

	val pivot = arr[eIndex]
	var biggerIndex = sIndex
	var swapCount = 0

	for (i in sIndex until eIndex) {
		val v = arr[i]
		if (v < pivot) {
			swap(arr, i, biggerIndex)
			biggerIndex++
			swapCount++
		}
		// there is no duplicate number in problem constraint
	}

	swap(arr, biggerIndex, eIndex)
	biggerIndex++
	swapCount++

	return swapCount + quickSortInPlaceCount(arr, sIndex, biggerIndex - 2) + quickSortInPlaceCount(arr, biggerIndex, eIndex)
}

fun swap(arr: Array<Int>, i: Int, j: Int) {
	val tmp = arr[i]
	arr[i] = arr[j]
	arr[j] = tmp
}

fun insertionSort2ShiftCountWithQuicksort(n: Int, arr: Array<Int>): Int {
	val curArr = arr.copyOf()
	var shiftCount = 0
	for (limit in 1 until n) {
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

	compareCount(arr)
}


