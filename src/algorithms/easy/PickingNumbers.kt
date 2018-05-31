package algorithms.easy

import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.max

fun pickingNumbers(a: Array<Int>): Int {
	val countMap = mutableMapOf<Int, Int>()
	a.forEach {
		countMap.compute(it, { _, v -> v?.let { v + 1 } ?: 1 })
	}

	val countList = countMap.toList().sortedBy { it.first }
	if (countList.size == 1)
		return countList.single().second

	val maxWith2ValPair = (0 until countList.size - 1).map {
		val (curVal, curCount) = countList[it]
		val (nextVal, nextCount) = countList[it + 1]
		(nextVal - curVal).absoluteValue to (curCount + nextCount)
	}
			.filter { (diff, _) -> diff == 1 }
			.maxBy { (_, count) -> count }

	val maxWith1ValCount = countList.maxBy { it.second }!!.second
	return maxWith2ValPair?.second?.let { max(maxWith1ValCount, it) } ?: maxWith1ValCount
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = pickingNumbers(a)

	println(result)
}
