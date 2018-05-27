package algorithms.easy

import java.util.*

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {
	val leftover = (n % s.length).toInt()
	val aCountInLeftover = s.substring(0, leftover).count { it == 'a' }
	val aInFullString = s.count { it == 'a' }

	return aCountInLeftover + aInFullString * (n / s.length)
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val s = scan.nextLine()

	val n = scan.nextLine().trim().toLong()

	val result = repeatedString(s, n)

	println(result)
}


