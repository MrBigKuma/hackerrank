package algorithms.easy

import java.util.*

// Complete the insertionSort2 function below.
fun insertionSort2(n: Int, arr: Array<Int>): Unit {
	val curArr = arr.copyOf()
	for (limit in 1..(n - 1)) {
		val newVal = arr[limit]

		for (i in limit downTo 0) {
			if (i == 0) {
				curArr[0] = newVal
				println(curArr.joinToString(" "))
				break
			}

			if (curArr[i - 1] > newVal) {
				curArr[i] = curArr[i - 1]
				continue
			}

			curArr[i] = newVal
			println(curArr.joinToString(" "))
			break
		}
	}
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	insertionSort2(n, arr)
}


