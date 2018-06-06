package algorithms.easy

import java.util.*

// Complete the twoStrings function below.
fun twoStrings(s1: String, s2: String): String {
	val charSet1 = s1.map { it }.toSet()
	val charSet2 = s2.map { it }.toSet()
	return if (charSet1.intersect(charSet2).isNotEmpty()) "YES" else "NO"
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val q = scan.nextLine().trim().toInt()

	for (qItr in 1..q) {
		val s1 = scan.nextLine()

		val s2 = scan.nextLine()

		val result = twoStrings(s1, s2)

		println(result)
	}
}


