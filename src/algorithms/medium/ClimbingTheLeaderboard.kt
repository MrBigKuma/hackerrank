package algorithms.medium

import java.util.*

fun climbingLeaderboard(scores: Array<Int>, alice: Array<Int>): Array<Int> {
	// To dense ranking
	val ranks = mutableListOf<Int>()
	scores.forEach { score ->
		if (ranks.isEmpty() || ranks.last() != score)
			ranks.add(score)
	}

	val aliceRanks = Array(alice.size, { 0 })
	var curRankIndex = 0
	var gameIndex = alice.lastIndex
	while (gameIndex >= 0) {
		val aliceScore = alice[gameIndex]
		while (curRankIndex < ranks.size) {
			val rankScore = ranks[curRankIndex]
			if (rankScore <= aliceScore) {
				aliceRanks[gameIndex] = curRankIndex + 1
				break
			}

			curRankIndex++
		}

		if (curRankIndex == ranks.size)
			break

		gameIndex--
	}

	// fill lowest ranks of alice
	aliceRanks.fill(ranks.size + 1, 0, gameIndex + 1)
	return aliceRanks
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val scoresCount = scan.nextLine().trim().toInt()

	val scores = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val aliceCount = scan.nextLine().trim().toInt()

	val alice = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = climbingLeaderboard(scores, alice)

	println(result.joinToString("\n"))
}
