package datastructure.easy

import java.util.*

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
	return (1 until arr.lastIndex).map { r ->
		(1 until arr.lastIndex).map { c ->
			arr[r][c] + arr[r - 1][c - 1] + arr[r - 1][c] + arr[r - 1][c + 1] + arr[r + 1][c - 1] + arr[r + 1][c] + arr[r + 1][c + 1]
		}.max()!!
	}.max()!!

}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

	for (i in 0 until 6) {
		arr[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
	}

	val result = hourglassSum(arr)

	println(result)
}


