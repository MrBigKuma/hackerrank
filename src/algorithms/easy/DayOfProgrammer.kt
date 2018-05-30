package algorithms.easy


import java.util.*

// Complete the solve function below.
fun solve(year: Int): String {
	if (year == 1918) {
		return "26.09.1918"
	}

	val isLeapYear = if (year >= 1919)
		year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)
	else
		year % 4 == 0

	if (isLeapYear)
		return "12.09.$year"

	return "13.09.$year"
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val year = scan.nextLine().trim().toInt()

	val result = solve(year)

	println(result)
}

