package algorithms.easy

import java.util.*
import kotlin.math.pow

// Complete the maximizingXor function below.
fun maximizingXor(l: Int, r: Int): Int {
	var l1 = l
	var r1 = r
	var diffBitCount = 0
	while (l1 != r1 && r1 > 0) {
		l1 = l1 shr 1
		r1 = r1 shr 1
		diffBitCount++
	}

	return (2.0).pow(diffBitCount).toInt() - 1
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val l = scan.nextLine().trim().toInt()

	val r = scan.nextLine().trim().toInt()

	val result = maximizingXor(l, r)

	println(result)
}
