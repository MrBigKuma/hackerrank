package algorithms.easy

import java.util.*

// Complete the acmTeam function below.
fun acmTeam(topic: Array<String>): Array<Int> {
	val m = topic[0].length
	var maxSubKnown = 0
	var count = 0
	(0 until topic.lastIndex).forEach { p1 ->
		(p1 + 1 until topic.size).forEach { p2 ->
			val s1 = topic[p1]
			val s2 = topic[p2]
			val subKnown = (0 until m).sumBy {
				if (s1[it] == '1' || s2[it] == '1') 1 else 0
			}

			if (subKnown == maxSubKnown)
				count++

			if (subKnown > maxSubKnown) {
				maxSubKnown = subKnown
				count = 1
			}
		}
	}

	return arrayOf(maxSubKnown, count)
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nm = scan.nextLine().split(" ")

	val n = nm[0].trim().toInt()

	val m = nm[1].trim().toInt()

	val topic = Array<String>(n, { "" })
	for (i in 0 until n) {
		val topicItem = scan.nextLine()
		topic[i] = topicItem
	}

	val result = acmTeam(topic)

	println(result.joinToString("\n"))
}


