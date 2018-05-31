package algorithms.easy

import java.util.*
import kotlin.math.min

fun pageCount(n: Int, p: Int): Int {
	val forwardCount = p / 2
	val backwardCount = n / 2 - forwardCount

	return min(forwardCount, backwardCount)
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val p = scan.nextLine().trim().toInt()

	val result = pageCount(n, p)

	println(result)
}
