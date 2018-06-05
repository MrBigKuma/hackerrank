package algorithms.easy

import java.util.*

// Complete the alternatingCharacters function below.
fun alternatingCharacters(s: String): Int {
	var count = 0
	var prev = 'C'
	s.forEach {
		if (it == prev) {
			count++
		} else {
			prev = it
		}
	}

	return count
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val q = scan.nextLine().trim().toInt()

	for (qItr in 1..q) {
		val s = scan.nextLine()

		val result = alternatingCharacters(s)

		println(result)
	}
}


