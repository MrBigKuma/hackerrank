package algorithms.easy

import java.util.*

// Complete the introTutorial function below.
fun introTutorial(V: Int, arr: Array<Int>): Int {
	for (i in 0..(arr.size - 1))
		if (arr[i] == V)
			return i

	return -1
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val V = scan.nextLine().trim().toInt()

	val n = scan.nextLine().trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = introTutorial(V, arr)

	println(result)
}


