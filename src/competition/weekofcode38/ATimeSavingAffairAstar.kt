package competition.weekofcode38

import java.util.*

// Complete the leastTimeToInterview function below.
fun leastTimeToInterview(n: Int, k: Int, m: Int, roads: Map<Int, MutableList<Road>>): Long {
	// Return the least amount of time needed to reach the interview location in seconds.
	val queue = PriorityQueue<AstarData>()

	queue.add(AstarData(1, 0L, 0L))

	while (queue.isNotEmpty()) {
		val (nodeId, traveledTime, _) = queue.poll()

		if (nodeId == m)
			return traveledTime

		queue.addAll(roads[nodeId]!!
				.filter { it.eId != nodeId }
				.map {
					val nextTraveledTime = calcTraveledTime(it, traveledTime, k, m)
					AstarData(it.eId, nextTraveledTime, calcHeuristicCost(roads[it.eId]!!, nextTraveledTime, k, m))
				})
	}

	return 0
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val k = scan.nextLine().trim().toInt()

	val m = scan.nextLine().trim().toInt()

	val roads = mutableMapOf<Int, MutableList<Road>>()
	(1..m).forEach {
		val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
		val i = a[0]
		val j = a[1]
		val t = a[2]
		roads.computeIfAbsent(i, { mutableListOf() }).add(Road(i, j, t))
		roads.computeIfAbsent(j, { mutableListOf() }).add(Road(j, i, t))
	}

	val result = leastTimeToInterview(n, k, m, roads)

	println(result)
}

fun calcTraveledTime(road: Road, sTime: Long, k: Int, m: Int): Long {
	if (road.eId == m)
		return sTime + road.time

	val endOfRoadTime = sTime + road.time
	val redLight = (endOfRoadTime / k) % 2 == 1L
	val waitTime = if (redLight) k - (endOfRoadTime % k) else 0
	return endOfRoadTime + waitTime
}

fun calcHeuristicCost(nextRoads: List<Road>, sTime: Long, k: Int, m: Int): Long {
	return sTime
//	return nextRoads.map { calcTraveledTime(it, sTime, k, m) }.min() ?: Long.MAX_VALUE
}

data class Road(val sId: Int, val eId: Int, val time: Int)

data class AstarData(val nodeId: Int, val traveledTime: Long, val heuristicCost: Long) : Comparable<AstarData> {
	override fun compareTo(other: AstarData): Int {
		return heuristicCost.compareTo(other.heuristicCost)
	}
}
