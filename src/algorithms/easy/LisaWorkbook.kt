package algorithms.easy

import java.util.*
import kotlin.math.ceil
import kotlin.math.min

// Complete the workbook function below.
fun workbook(n: Int, k: Int, arr: Array<Int>): Int {
	if (k == 1)
		return arr.sum()

	// TODO: we can use math to count instead of loop, but may be it is overcomplicated?
	var pageIndex = 0
	var specialCount = 0
	for (probCount in arr) {
		val chapPageCount = ceil(probCount.toDouble() / k).toInt()
		for (chapPageIndex in 0..chapPageCount) {
			val chapProbIndexInPage = IntRange(chapPageIndex * k + 1, min((chapPageIndex + 1) * k, probCount))
			if (chapProbIndexInPage.contains(pageIndex + chapPageIndex + 1))
				specialCount++
		}

		pageIndex += chapPageCount
	}

	return specialCount
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nk = scan.nextLine().split(" ")

	val n = nk[0].trim().toInt()

	val k = nk[1].trim().toInt()

	val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = workbook(n, k, arr)

	println(result)
}
