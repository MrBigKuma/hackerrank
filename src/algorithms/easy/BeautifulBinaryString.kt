package algorithms.easy

import java.util.*

// Complete the beautifulBinaryString function below.
fun beautifulBinaryString(b: String): Int {
	var i = 0
	var count = 0
	while (i < b.length - 2) {
		if (b.subSequence(i, i+3) == "010") {
			count++
			i += 3
			continue
		}

		i++
	}
	return count
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val b = scan.nextLine()

	val result = beautifulBinaryString(b)

	println(result)
}


