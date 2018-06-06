package algorithms.easy

import java.util.*
import kotlin.math.max

// Complete the weightedUniformStrings function below.
fun weightedUniformStrings(s: String, queries: Array<Int>): Array<String> {
	val baseCharCode = 'a'.toInt() - 1
	val conCharMaxCount = mutableMapOf<Int, Int>()
	var prevCharCode = 0
	var curConCharCount = 0
	for (c in s) {
		val cCode = c.toInt() - baseCharCode
		if (cCode == prevCharCode) {
			curConCharCount++
		} else {
			curConCharCount = 1
			prevCharCode = cCode
		}

		conCharMaxCount.compute(cCode, { _, v -> v?.let { max(curConCharCount, v) } ?: curConCharCount })
	}

	return queries.map { q ->
		conCharMaxCount.any { (cCode, maxCount) ->
			q % cCode == 0 && (q / cCode) <= maxCount
		}
	}.map { if (it) "Yes" else "No" }.toTypedArray()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val s = scan.nextLine()

	val queriesCount = scan.nextLine().trim().toInt()

	val queries = Array<Int>(queriesCount, { 0 })
	for (i in 0 until queriesCount) {
		val queriesItem = scan.nextLine().trim().toInt()
		queries[i] = queriesItem
	}

	val result = weightedUniformStrings(s, queries)

	println(result.joinToString("\n"))
}


