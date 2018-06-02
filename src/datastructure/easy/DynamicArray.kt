package datastructure.easy

import java.util.*

fun dynamicArray(n: Int, queries: Array<Array<Int>>) {
	val arr = Array<MutableList<Int>>(n, { mutableListOf() })
	var lastAnswer = 0
	queries.forEach { q ->
		val cat = q[0]
		val x = q[1]
		val y = q[2]

		val seq = arr[(x.xor(lastAnswer) % n)]
		if (cat == 1) {
			seq.add(y)
		} else {
			lastAnswer = seq[y % seq.size]
			println(lastAnswer)
		}
	}
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nq = scan.nextLine().split(" ")

	val n = nq[0].trim().toInt()

	val q = nq[1].trim().toInt()

	val queries = Array<Array<Int>>(q, { Array<Int>(3, { 0 }) })

	for (queriesRowItr in 0 until q) {
		queries[queriesRowItr] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
	}

	dynamicArray(n, queries)
}


