package algorithms.easy

import java.util.*

// Complete the marcsCakewalk function below.
fun marcsCakewalk(calorie: Array<Int>): Long {
	var pow = 1L
	val sortedCalories = calorie.sortedArrayDescending()
	var totalCal = 0L
	for (c in sortedCalories) {
		totalCal += c * pow
		pow *= 2
	}

	return totalCal
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val calorie = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = marcsCakewalk(calorie)

	println(result)
}


