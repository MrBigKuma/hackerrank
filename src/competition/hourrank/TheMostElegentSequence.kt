package competition.hourrank

import java.util.*

// Complete the maximumElegance function below.
fun maximumElegance(q: Int, s: Array<String>, bList: Array<Int>): Int {
	val charCount = mutableMapOf<Char, Int>()
	('0'..'9').forEach { charCount.put(it, q) }
	val formableBList = mutableListOf<Int>()
	(0 until s.size).forEach { index ->
		val si = s[index]
		if (si.all { charCount[it]!! > 0 }) {
			si.forEach { charCount[it] = charCount[it]!! - 1 }
			formableBList.add(bList[index])
		}
	}

	return (0 until formableBList.size).map { index ->
		val newList = formableBList.withIndex().filter { it.index != index }.map { it.value }
		bList[index] + maxXor(bList[index], newList)
	}.max()!!
}

fun maxXor(prevB: Int, bList: List<Int>): Int {
	if (bList.isEmpty())
		return 0

	return bList.withIndex().map { (index, b) ->
		val newList = bList.withIndex().filter { it.index != index }.map { it.value }
		prevB.xor(b) + maxXor(b, newList)
	}.max()!!
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nq = scan.nextLine().split(" ")

	val n = nq[0].trim().toInt()

	val q = nq[1].trim().toInt()

	val b = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val s = Array<String>(n, { "" })
	for (i in 0 until n) {
		val sItem = scan.nextLine()
		s[i] = sItem
	}

	val result = maximumElegance(q, s, b)

	println(result)
}
