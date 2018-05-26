package algorithms.medium

import java.util.*
import kotlin.math.absoluteValue

// Complete the surfaceArea function below.
fun surfaceArea(A: Array<Array<Int>>): Int {
	var sCount = 0
	for (r in A) {
		var prevHeight = 0
		for (cellHeight in r) {
			sCount += (cellHeight - prevHeight).absoluteValue
			prevHeight = cellHeight
		}
		sCount += prevHeight
	}

	for (cIndex in 0..(A[0].size - 1)) {
		var prevHeight = 0
		for (rIndex in 0..(A.size - 1)) {
			val cellHeight = A[rIndex][cIndex]
			sCount += (cellHeight - prevHeight).absoluteValue
			prevHeight = cellHeight
		}
		sCount += prevHeight
	}

	return A.size * A[0].size * 2 + sCount
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val HW = scan.nextLine().split(" ")

	val H = HW[0].trim().toInt()

	val W = HW[1].trim().toInt()

	val A = Array<Array<Int>>(H, { Array<Int>(W, { 0 }) })

	for (i in 0 until H) {
		A[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
	}

	val result = surfaceArea(A)

	println(result)
}


