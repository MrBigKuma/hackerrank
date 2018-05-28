package algorithms.easy

import java.util.*

// Complete the findDigits function below.
fun findDigits(n: Int): Int {
	return n.toString()
			.map { it.toString().toInt() }
			.filter { it > 0 }
			.filter { n % it == 0 }
			.count()

}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val t = scan.nextLine().trim().toInt()

	for (tItr in 1..t) {
		val n = scan.nextLine().trim().toInt()

		val result = findDigits(n)

		println(result)
	}
}
