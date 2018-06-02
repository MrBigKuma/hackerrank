package datastructure.easy

import java.util.*

fun QHEAP1(queries: Array<Array<Int>>) {
	// 1st is value, 2nd is stackMax
	val heap = LinkedList<Int>()
	queries.forEach { query ->
		val cat = query[0]
		when (cat) {
			1 -> {
				val v = query[1]
				heap.add(v)
			}
			2 -> {
				val v = query[1]
				heap.remove(v)
			}
			3 -> {
				println(heap.min())
			}
		}
	}
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val arrCount = scan.nextLine().trim().toInt()

	val queries = Array(arrCount, { Array(0, { 0 }) })
	(0 until queries.size).forEach {
		queries[it] = scan.nextLine().split(" ").map { it.toInt() }.toTypedArray()
	}

	QHEAP1(queries)
}

