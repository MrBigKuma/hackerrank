package algorithms.easy

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.math.absoluteValue
import kotlin.ranges.*
import kotlin.text.*

// Complete the algorithms.easy.diagonalDifference function below.
fun diagonalDifference(a: Array<Array<Int>>): Int {
	val n = a.size
	var sum = 0
	for(i in 0..(n-1)) {
		sum += a[i][i] - a[i][n - i - 1]
	}
	return sum.absoluteValue
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val a = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

	for (i in 0 until n) {
		a[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
	}

	val result = diagonalDifference(a)

	println(result)
}
