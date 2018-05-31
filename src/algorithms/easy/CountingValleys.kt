package algorithms.easy

import java.util.*

fun countingValleys(n: Int, s: String): Int {
	var valleyCount = 0
	var altitude = 0
	for (step in s) {
		altitude += if (step == 'D') -1 else 1

		if (step == 'D' && altitude == -1)
			valleyCount++
	}

	return valleyCount
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val s = scan.nextLine()

	val result = countingValleys(n, s)

	println(result)
}
