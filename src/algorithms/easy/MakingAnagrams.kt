package algorithms.easy

import java.util.*
import kotlin.math.absoluteValue

// Complete the makingAnagrams function below.
fun makingAnagrams(s1: String, s2: String): Int {
	val charCountMap = mutableMapOf<Char, Int>()

	s1.forEach {
		charCountMap.compute(it, { _, v -> v?.let { v + 1 } ?: 1 })
	}
	s2.forEach {
		charCountMap.compute(it, { _, v -> v?.let { v - 1 } ?: -1 })
	}

	return charCountMap.values.map { it.absoluteValue }.sum()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val s1 = scan.nextLine()

	val s2 = scan.nextLine()

	val result = makingAnagrams(s1, s2)

	println(result)
}
