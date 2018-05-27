package algorithms.easy

import java.util.*

// Complete the insertionSort1 function below.
fun insertionSort1(n: Int, arr: Array<Int>): Unit {
	val newVal = arr.last()
	val curArr = arr.copyOf()
	for (i in (n - 1) downTo 0) {
		if (i == 0) {
			curArr[0] = newVal
			println(curArr.joinToString(" "))
			break
		}

		if (curArr[i - 1] > newVal) {
			curArr[i] = curArr[i - 1]
			println(curArr.joinToString(" "))
			continue
		}

		curArr[i] = newVal
		println(curArr.joinToString(" "))
		break
	}
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	insertionSort1(n, arr)
}


