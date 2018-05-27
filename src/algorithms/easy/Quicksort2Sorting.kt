package algorithms.easy

import java.util.*

// Complete the quickSort function below.
fun quickSort2(arr: Array<Int>): Array<Int> {
	if (arr.size <= 1)
		return arr

	val pivot = arr[0]
	val smallers = mutableListOf<Int>()
	val equals = mutableListOf<Int>()
	val biggers = mutableListOf<Int>()

	for (v in arr) {
		if (v < pivot)
			smallers.add(v)

		if (v == pivot)
			equals.add(v)

		if (v > pivot)
			biggers.add(v)
	}

	val rst = quickSort2(smallers.toTypedArray()) + equals + quickSort2(biggers.toTypedArray())
	println(rst.joinToString(" "))
	return rst
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = quickSort2(arr)
}


