package datastructure.easy

import java.util.*
import kotlin.math.max

fun processMaximumStack(queries: Array<Array<Int>>) {
	// 1st is value, 2nd is stackMax
	val stack = LinkedList<Pair<Int, Int>>()
	queries.forEach { query ->
		val cat = query[0]
		when (cat) {
			1 -> {
				val v = query[1]
				val stackMax = stack.firstOrNull()?.second?.let { max(it, v) } ?: v
				stack.addFirst(v to stackMax)
			}
			2 -> {
				if (stack.isNotEmpty())
					stack.removeFirst()
			}
			3 -> {
				println(stack.first!!.second)
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

	processMaximumStack(queries)
}

