package algorithms.easy

import java.util.*

fun gradingStudents(grades: Array<Int>): Array<Int> {
	return grades.map {
		if (it < 38)
			return@map it

		if (it % 5 > 2)
			return@map it - (it % 5) + 5

		it
	}.toTypedArray()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val grades = Array<Int>(n, { 0 })
	for (gradesItr in 0 until n) {
		val gradesItem = scan.nextLine().trim().toInt()
		grades[gradesItr] = gradesItem
	}

	val result = gradingStudents(grades)

	println(result.joinToString("\n"))
}


