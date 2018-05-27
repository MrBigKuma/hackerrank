package algorithms.easy

import java.util.*

// Complete the cavityMap function below.
fun cavityMap(grid: Array<String>): Array<String> {
	val lastIndex = grid.lastIndex
	for (r in 1 until lastIndex) {
		for (c in 1 until lastIndex) {
			val v = grid[r][c].toString().toIntOrNull() ?: Int.MAX_VALUE
			val up = grid[r - 1][c].toString().toIntOrNull() ?: Int.MAX_VALUE
			val down = grid[r + 1][c].toString().toIntOrNull() ?: Int.MAX_VALUE
			val left = grid[r][c - 1].toString().toIntOrNull() ?: Int.MAX_VALUE
			val right = grid[r][c + 1].toString().toIntOrNull() ?: Int.MAX_VALUE

			if (v > up && v > down && v > left && v > right)
				grid[r] = grid[r].replaceRange(c, c + 1, "X")
		}
	}
	return grid
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val grid = Array<String>(n, { "" })
	for (i in 0 until n) {
		val gridItem = scan.nextLine()
		grid[i] = gridItem
	}

	val result = cavityMap(grid)

	println(result.joinToString("\n"))
}


