package competition.weekofcode38

import java.util.*

// Complete the cyclicalQueries function below.
fun cyclicalQueries(n: Int, w: Array<Long>, queries: Array<List<String>>) {
	// Return the list of answers to all queries of type 4. Take the query information from standard input.
	val m = queries.size
	val nodes = Array<PriorityQueue<NewNode>>(n, { PriorityQueue() })
	(0 until m).forEach { qIdx ->
		val q = queries[qIdx]
		val x = q[1].toInt() - 1
		when (q[0][0]) {
			'1' -> {
				val newW = q[2].toLong()
				val (farthestIdx, _) = findFarthestNode(x, n, w, nodes)
				val queue = nodes[farthestIdx]
				queue.add(NewNode((queue.peek()?.accW ?: 0) + newW, qIdx))
			}

			'2' -> {
				val newW = q[2].toLong()
				nodes[x].add(NewNode(newW, qIdx))
			}

			'3' -> {
				val (farthestIdx) = findFarthestNode(x, n, w, nodes)
				nodes[farthestIdx].poll()
			}

			'4' -> {
				val (_, farthestDist) = findFarthestNode(x, n, w, nodes)
				println(farthestDist)
			}
		}
	}
}

private fun findFarthestNode(x: Int, n: Int, w: Array<Long>, nodes: Array<PriorityQueue<NewNode>>): Pair<Int, Long> {
	var farthestIdx = x
	var farthestDist = 0L
	var origNodeDist = 0L
	for (i in x until x + n) {
		val idx = i % n
		val maxDistFromNode = nodes[idx].peek()?.accW ?: 0
		val dist = origNodeDist + maxDistFromNode
		if (dist > farthestDist) {
			farthestIdx = idx
			farthestDist = dist
		}
		origNodeDist += w[idx]
	}
	return Pair(farthestIdx, farthestDist)
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val w = scan.nextLine().split(" ").map { it.trim().toLong() }.toTypedArray()

	val m = scan.nextLine().trim().toInt()

	val queries = Array<List<String>>(m, { scan.nextLine().split(' ') })
	cyclicalQueries(n, w, queries)
}

class NewNode(val accW: Long, val qIdx: Int) : Comparable<NewNode> {
	override fun compareTo(other: NewNode): Int {
		return comparator.compare(other, this)
	}

	companion object {
		private val comparator = compareBy<NewNode> { it.accW }.thenBy { it.qIdx }
	}
}

