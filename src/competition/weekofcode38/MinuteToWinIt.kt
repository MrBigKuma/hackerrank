package competition.weekofcode38

import java.util.*

// Complete the minuteToWinIt function below.
fun minuteToWinIt(a: Array<Int>, k: Int): Int {
	val countMap = mutableMapOf<Long, Int>()
	a.forEachIndexed { index, ai ->
		countMap.compute(ai.toLong() - index.toLong() * k, { _, v -> v?.let { v + 1 } ?: 1 })
	}
	val (_, maxCount) = countMap.maxBy { it.value }!!

	return a.size - maxCount

}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nk = scan.nextLine().split(" ")

	val n = nk[0].trim().toInt()

	val k = nk[1].trim().toInt()

	val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = minuteToWinIt(a, k)

	println(result)
}


