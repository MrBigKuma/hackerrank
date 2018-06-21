package competition.weekofcode38

import java.util.*

// Complete the cyclicalQueries function below.
fun cyclicalQueries(n: Int, w: Array<Long>, queries: List<Array<Int>>) {
	// Return the list of answers to all queries of type 4. Take the query information from standard input.
	val m = queries.size
	val nodes = Array<LinkedList<LinkedList<NewNode>>>(n, { LinkedList() })
	(0 until m).forEach { qIdx ->
		val q = queries[qIdx]
		val x = q[1] - 1
		when (q[0]) {
			1 -> {
				val newW = q[2]
				var (farthestIdx, farthestStack: LinkedList<NewNode>?) = findFarthestNode(x, n, w, nodes)

				// add new Node
				if (farthestStack == null) {
					farthestStack = LinkedList()
					farthestStack.add(NewNode(newW.toLong(), qIdx))
					nodes[farthestIdx].add(farthestStack)
				} else {
					farthestStack.add(NewNode(farthestStack.last.accW + newW, qIdx))
				}

			}

			2 -> {
				val newW = q[2]
				val stack = LinkedList<NewNode>()
				stack.add(NewNode(newW.toLong(), qIdx))
				nodes[x].add(stack)
			}

			3 -> {
				val (farthestIdx, farthestStack: LinkedList<NewNode>?) = findFarthestNode(x, n, w, nodes)
				if (farthestStack!!.size == 1)
					nodes[farthestIdx].remove(farthestStack)
				else
					farthestStack.removeLast()
			}

			4 -> {
				val (_, _, farthestDist) = findFarthestNode(x, n, w, nodes)
				println(farthestDist)
			}
		}
	}
}

private fun findFarthestNode(x: Int, n: Int, w: Array<Long>, nodes: Array<LinkedList<LinkedList<NewNode>>>): Triple<Int, LinkedList<NewNode>?, Long> {
	var farthestIdx = x
	var farthestStack: LinkedList<NewNode>? = null
	var farthestDist = 0L
	var origNodeDist = 0L
	for (i in x until x + n) {
		val stack = nodes[i % n].maxWith(compareBy<LinkedList<NewNode>> { it.last.accW }.thenBy { it.last.qIdx })
		val maxDistFromNode = stack?.last?.accW ?: 0
		val dist = origNodeDist + maxDistFromNode
		if (dist > farthestDist) {
			farthestIdx = i % n
			farthestDist = dist
			farthestStack = stack
		}
		origNodeDist += w[i % n]
	}
	return Triple(farthestIdx, farthestStack, farthestDist)
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val w = scan.nextLine().split(" ").map { it.trim().toLong() }.toTypedArray()

	val m = scan.nextLine().trim().toInt()

	val queries = (0 until m).map {
		scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
	}
	cyclicalQueries(n, w, queries)
}

data class NewNode(val accW: Long, val qIdx: Int)
