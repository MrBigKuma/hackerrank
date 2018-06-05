package algorithms.easy

import java.lang.Math.abs
import java.util.*

// Complete the theLoveLetterMystery function below.
fun theLoveLetterMystery(s: String): Int {
	return (0 until s.length / 2).sumBy {
		abs(s[it].toInt() - s[s.lastIndex - it].toInt())
	}
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val q = scan.nextLine().trim().toInt()

	for (qItr in 1..q) {
		val s = scan.nextLine()

		val result = theLoveLetterMystery(s)

		println(result)
	}
}
