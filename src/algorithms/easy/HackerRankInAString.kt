package algorithms.easy


import java.util.*

// Complete the hackerrankInString function below.
fun hackerrankInString(s: String): String {
	val targetStr = "hackerrank"
	var targetIdx = 0
	for (c in s) {
		if (targetIdx == targetStr.length)
			break

		if (c == targetStr[targetIdx])
			targetIdx++
	}

	return if (targetIdx == targetStr.length) "YES" else "NO"
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val q = scan.nextLine().trim().toInt()

	for (qItr in 1..q) {
		val s = scan.nextLine()

		val result = hackerrankInString(s)

		println(result)
	}
}
