package competition.hourrank

import java.util.*

// Complete the lagDuration function below.
fun lagDuration(h1: Int, m1: Int, h2: Int, m2: Int, k: Int): Int {
	// Return an integer denoting the duration of time in minutes by which the clock has been lagging.
	val expect = (h1 + k) * 60 + m1
	val actual = h2 * 60 + m2
	return expect - actual
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val q = scan.nextLine().trim().toInt()

	for (qItr in 1..q) {
		val h1M1H2M2 = scan.nextLine().split(" ")

		val h1 = h1M1H2M2[0].trim().toInt()

		val m1 = h1M1H2M2[1].trim().toInt()

		val h2 = h1M1H2M2[2].trim().toInt()

		val m2 = h1M1H2M2[3].trim().toInt()

		val k = scan.nextLine().trim().toInt()

		val result = lagDuration(h1, m1, h2, m2, k)

		println(result)
	}
}


