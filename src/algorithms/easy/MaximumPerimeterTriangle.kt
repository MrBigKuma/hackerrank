package algorithms.easy

import java.util.*

// Complete the maximumPerimeterTriangle function below.
fun maximumPerimeterTriangle(sticks: Array<Int>): Array<Int> {
	val sortedSticks = sticks.sortedArray()

	(sortedSticks.lastIndex downTo 2).forEach {
		val a = sortedSticks[it]
		val b = sortedSticks[it - 1]
		val c = sortedSticks[it - 2]
		if (isTriangle(a, b, c))
			return arrayOf(c, b, a)
	}

	return arrayOf(-1)
}

fun isTriangle(a: Int, b: Int, c: Int): Boolean {
	return a + b > c && a + c > b && b + c > a
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val sticks = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = maximumPerimeterTriangle(sticks)

	println(result.joinToString(" "))
}


