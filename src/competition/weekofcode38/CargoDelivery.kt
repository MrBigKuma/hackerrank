package competition.weekofcode38

import java.util.*
import kotlin.math.ceil
import kotlin.math.max


// Complete the minimumBrokenness function below.
fun minimumBrokenness(n: Int, m: Int, k: Int, t: Int, graph: Map<Int, MutableMap<Int, Int>>): Int {
	// Return the minimum possible brokenness of a truck among all k trucks driving from city 0 to city n-1. Take the information about roads from standard input.

	var shortestPath = Integer.MAX_VALUE
	var maxFlow = 0
	val parent = IntArray(n)
	while (true) {
		val pathLen = bfs(n, graph, parent)
		if (pathLen <= 0)
			break

		var v = n - 1
		while (v != 0) {
			val u = parent[v]
			graph[u]!!.compute(v, { _, count -> count!! - 1 })
			graph[v]!!.compute(u, { _, count -> count!! + 1 })
			v = parent[v]
		}

		maxFlow++
		if (pathLen < shortestPath)
			shortestPath = pathLen
	}

	val truckNumThroughShortestPath = ceil(k.toDouble() / maxFlow).toInt()
	val fixableBrokenness = t / shortestPath
	return max(0, truckNumThroughShortestPath - 1 - fixableBrokenness)
}

fun bfs(n: Int, graph: Map<Int, Map<Int, Int>>, parent: IntArray): Int {
	val visited = mutableMapOf<Int, Int>()

	val queue = LinkedList<Int>()
	queue.add(0)
	visited[0] = 0
	parent[0] = -1

	while (queue.isNotEmpty()) {
		val u = queue.poll()
		if (u == n - 1) break

		for ((v, thoughput) in graph[u]!!) {
			if (visited.contains(v) || thoughput <= 0) continue

			queue.add(v)
			parent[v] = u
			visited[v] = visited[u]!! + 1
		}
	}

	return visited[n - 1] ?: 0
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nmkt = scan.nextLine().split(" ")

	val n = nmkt[0].trim().toInt()

	val m = nmkt[1].trim().toInt()

	val k = nmkt[2].trim().toInt()

	val t = nmkt[3].trim().toInt()

	val graph = mutableMapOf<Int, MutableMap<Int, Int>>()
	(1..m).forEach {
		val e = scan.nextLine().split(" ").map { it.toInt() }
		graph.putIfAbsent(e[0], mutableMapOf())
		graph[e[0]]!![e[1]] = 1
		graph.putIfAbsent(e[1], mutableMapOf())
		graph[e[1]]!![e[0]] = 1
	}

	val result = minimumBrokenness(n, m, k, t, graph)

	println(result)
}
