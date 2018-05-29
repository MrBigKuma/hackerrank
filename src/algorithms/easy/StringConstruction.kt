package algorithms.easy

import java.util.*

// Complete the stringConstruction function below.
fun stringConstruction(s: String): Int {
	return s.map { it }.toSet().count()

}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val q = scan.nextLine().trim().toInt()

	for (qItr in 1..q) {
		val s = scan.nextLine()

		val result = stringConstruction(s)

		println(result)
	}
}


