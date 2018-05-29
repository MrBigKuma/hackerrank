package algorithms.easy

import java.util.*
import kotlin.math.absoluteValue

// Complete the funnyString function below.
fun funnyString(s: String): String {
	val n = s.length
	if (n <= 2)
		return "Funny"

	val anyDiff = (0 until (n / 2)).any {
		val d1 = (s[it].toInt() - s[it + 1].toInt()).absoluteValue
		val d2 = (s[n - it - 1].toInt() - s[n - it - 2].toInt()).absoluteValue
		d1 != d2
	}

	return if (anyDiff)
		"Not Funny"
	else
		"Funny"

}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val q = scan.nextLine().trim().toInt()

	for (qItr in 1..q) {
		val s = scan.nextLine()

		val result = funnyString(s)

		println(result)
	}
}
