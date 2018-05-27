package algorithms.medium

import java.util.*

// Complete the quickSort function below.
fun quickSortInPlace(arr: Array<Int>, sIndex: Int, eIndex: Int) {
	if (sIndex >= eIndex)
		return

	val pivot = arr[eIndex]
	var biggerIndex = sIndex

	for (i in sIndex until eIndex ) {
		val v = arr[i]
		if (v < pivot) {
			swap(arr, i, biggerIndex)
			biggerIndex++
		}
		// there is no duplicate number in problem constraint
	}

	swap(arr, biggerIndex, eIndex)
	biggerIndex++
	println(arr.joinToString(" "))

	quickSortInPlace(arr, sIndex, biggerIndex - 2)
	quickSortInPlace(arr, biggerIndex, eIndex)
}

fun swap(arr: Array<Int>, i: Int, j: Int) {
	val tmp = arr[i]
	arr[i] = arr[j]
	arr[j] = tmp
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	quickSortInPlace(arr, 0, arr.lastIndex)
}



