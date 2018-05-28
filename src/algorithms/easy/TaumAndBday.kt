package algorithms.easy

import java.util.*
import kotlin.math.min

// Complete the taumBday function below.
fun taumBday(b: Int, w: Int, bc: Int, wc: Int, z: Int): Long {
	val minBCost = min(bc, wc + z)
	val minWCost = min(wc, bc + z)
	return b.toLong() * minBCost + w.toLong() * minWCost
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val t = scan.nextLine().trim().toInt()

	for (tItr in 1..t) {
		val bw = scan.nextLine().split(" ")

		val b = bw[0].trim().toInt()

		val w = bw[1].trim().toInt()

		val bcWcz = scan.nextLine().split(" ")

		val bc = bcWcz[0].trim().toInt()

		val wc = bcWcz[1].trim().toInt()

		val z = bcWcz[2].trim().toInt()

		val result = taumBday(b, w, bc, wc, z)

		println(result)
	}
}


