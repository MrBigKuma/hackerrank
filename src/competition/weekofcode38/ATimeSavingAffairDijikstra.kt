package competition.weekofcode38

import java.util.*
import kotlin.math.min

// Complete the leastTimeToInterview function below.
fun leastTimeToInterviewDijikstra(n: Int, k: Int, m: Int, graph: Array<MutableMap<Int, Int>>): Long {
	// Return the least amount of time needed to reach the interview location in seconds.
	val checkedSet = Array(n + 1, { false })
	val traveledTimeSet = Array(n + 1, { Long.MAX_VALUE })

	traveledTimeSet[1] = 0

	(1 until n).forEach {
		val v = minOfNotCheckedVertex(checkedSet, traveledTimeSet)
		checkedSet[v] = true

		val traveledTime = traveledTimeSet[v]
		val waitTime = redLightWaitTime(traveledTime, k)
		graph[v].forEach { eV, t ->
			if (traveledTimeSet[eV] > traveledTime + waitTime + t)
				traveledTimeSet[eV] = traveledTime + waitTime + t
		}
	}

	return traveledTimeSet[n]
}

fun minOfNotCheckedVertex(checkedSet: Array<Boolean>, distSet: Array<Long>): Int {
	return (1 until distSet.size)
			.filterNot { checkedSet[it] }
			.minBy { idx -> distSet[idx] }!!
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val k = scan.nextLine().trim().toInt()

	val m = scan.nextLine().trim().toInt()

	val graph = Array<MutableMap<Int, Int>>(n + 1, { mutableMapOf() })
	(1..m).forEach {
		val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
		val i = a[0]
		val j = a[1]
		val t = a[2]
		graph[i].compute(j, { _, v -> v?.let { min(it, t) } ?: t})
		graph[j].compute(i, { _, v -> v?.let { min(it, t) } ?: t})
	}

	val result = leastTimeToInterviewDijikstra(n, k, m, graph)

	println(result)
}

fun redLightWaitTime(sTime: Long, k: Int): Long {
	val redLight = (sTime / k) % 2 == 1L
	return if (redLight) k - (sTime % k) else 0
}
