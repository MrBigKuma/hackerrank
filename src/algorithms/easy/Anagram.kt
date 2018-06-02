package algorithms.easy


import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.round

// Complete the anagram function below.
fun anagram(s: String): Int {
	if (s.length % 2 == 1)
		return -1

	val charCountMap = mutableMapOf<Char, Int>()

	s.subSequence(0, s.length / 2).forEach {
		charCountMap.compute(it, { _, v -> v?.let { v + 1 } ?: 1 })
	}
	s.subSequence(s.length / 2, s.length).forEach {
		charCountMap.compute(it, { _, v -> v?.let { v - 1 } ?: -1 })
	}

	return round(charCountMap.values.map { it.absoluteValue }.sum().toDouble() / 2).toInt()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val q = scan.nextLine().trim().toInt()

	for (qItr in 1..q) {
		val s = scan.nextLine()

		val result = anagram(s)

		println(result)
	}
}

