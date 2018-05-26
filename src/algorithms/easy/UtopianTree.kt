package algorithms.easy

import java.util.*

// Complete the utopianTree function below.
fun utopianTree(n: Int): Int {
	var height = 1

	for (i in 1..n)
		height = if (i % 2 == 1) height * 2 else height + 1

	return height
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val t = scan.nextLine().trim().toInt()

	for (tItr in 1..t) {
		val n = scan.nextLine().trim().toInt()

		val result = utopianTree(n)

		println(result)
	}
}


