package algorithms.easy

import java.util.*

// Complete the quickSort function below.
fun quickSort(arr: Array<Int>): Array<Int> {
	val pivot = arr[0]
	val smallers = LinkedList<Int>()
	val equals = LinkedList<Int>()
	val biggers = LinkedList<Int>()

	for (v in arr) {
		if (v < pivot)
			smallers.add(v)

		if (v == pivot)
			equals.add(v)

		if (v > pivot)
			biggers.add(v)
	}

	return (smallers + equals + biggers).toTypedArray()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = quickSort(arr)

	println(result.joinToString(" "))
}

