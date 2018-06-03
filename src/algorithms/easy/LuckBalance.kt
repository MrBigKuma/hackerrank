package algorithms.easy

import java.util.*

// Complete the luckBalance function below.
fun luckBalance(n: Int, k: Int, contests: Array<Array<Int>>): Int {
	val sortedImportantContests = contests.filter { it[1] == 1 }.sortedBy { it[0] }
	val minMustWinContestCount = sortedImportantContests.size - k
	val minWinContestPoint = sortedImportantContests.withIndex()
			.filter { (index, _) -> index < minMustWinContestCount }
			.sumBy { it.value[0] }

	return contests.sumBy { it[0] } - minWinContestPoint * 2
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nk = scan.nextLine().split(" ")

	val n = nk[0].trim().toInt()

	val k = nk[1].trim().toInt()

	val contests = Array<Array<Int>>(n, { Array<Int>(2, { 0 }) })

	for (i in 0 until n) {
		contests[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
	}

	val result = luckBalance(n, k, contests)

	println(result)
}

