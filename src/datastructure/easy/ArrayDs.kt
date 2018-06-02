package datastructure.easy

import java.util.*

// Complete the reverseArray function below.
fun reverseArray(a: Array<Int>): Array<Int> {
	return Array(a.size, { a[a.lastIndex - it] })
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val arrCount = scan.nextLine().trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val res = reverseArray(arr)

	println(res.joinToString(" "))
}

