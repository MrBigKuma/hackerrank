package competition.weekofcode38

import java.util.*

// Complete the whichSection function below.
fun whichSection(n: Int, k: Int, a: Array<Int>): Int {
	// Return the section number you will be assigned to assuming you are student number k.
	var accStudentCount = 0
	for (aIndex in 0 until a.size) {
		val sectionStudent = a[aIndex]
		if (k <= accStudentCount + sectionStudent)
			return aIndex + 1

		accStudentCount += sectionStudent
	}

	return 0
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val t = scan.nextLine().trim().toInt()

	for (tItr in 1..t) {
		val nkm = scan.nextLine().split(" ")

		val n = nkm[0].trim().toInt()

		val k = nkm[1].trim().toInt()

		val m = nkm[2].trim().toInt()

		val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

		val result = whichSection(n, k, a)

		println(result)
	}
}
