package algorithms.easy

import java.util.*

// Complete the twoArrays function below.
fun twoArrays(k: Int, A: Array<Int>, B: Array<Int>): String {
	val sortedA = A.sortedArray()
	val sortedB = B.toMutableList()
	sortedB.sort()

	var invalid = false
	for (aIndex in 0 until sortedA.size) {
		val a = sortedA[aIndex]
		var opponentVal = false
		for (bIndex in 0 until sortedB.size) {
			val b = sortedB[bIndex]
			if (a + b >= k) {
				sortedB.removeAt(bIndex)
				opponentVal = true
				break
			}
		}

		if (!opponentVal) {
			invalid = true
			break
		}
	}

	return if (invalid)
		"NO"
	else
		"YES"
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val q = scan.nextLine().trim().toInt()

	for (qItr in 1..q) {
		val nk = scan.nextLine().split(" ")

		val n = nk[0].trim().toInt()

		val k = nk[1].trim().toInt()

		val A = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

		val B = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

		val result = twoArrays(k, A, B)

		println(result)
	}
}


