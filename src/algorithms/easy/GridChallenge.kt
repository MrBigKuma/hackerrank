package algorithms.easy

import java.util.*

// Complete the gridChallenge function below.
fun gridChallenge(grid: Array<String>): String {
	val sortedGrid = grid.map {
		it.toCharArray().sortedArray()
	}

	val inOrder = (0 until sortedGrid[0].size).all { col ->
		(0 until sortedGrid.lastIndex).all { row ->
			sortedGrid[row][col] <= sortedGrid[row + 1][col]
		}
	}

	return if(inOrder) "YES" else "NO"
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val t = scan.nextLine().trim().toInt()

	for (tItr in 1..t) {
		val n = scan.nextLine().trim().toInt()

		val grid = Array<String>(n, { "" })
		for (i in 0 until n) {
			val gridItem = scan.nextLine()
			grid[i] = gridItem
		}

		val result = gridChallenge(grid)

		println(result)
	}
}


