package algorithms.easy


import java.util.*

// Complete the beautifulTriplets function below.
fun beautifulTriplets(d: Int, arr: Array<Int>): Int {
	val numSet = arr.toSet()
	return (0 until (arr.size - 2)).count {
		numSet.contains(arr[it] + d) && numSet.contains(arr[it] + 2 * d)
	}
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nd = scan.nextLine().split(" ")

	val n = nd[0].trim().toInt()

	val d = nd[1].trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = beautifulTriplets(d, arr)

	println(result)
}

