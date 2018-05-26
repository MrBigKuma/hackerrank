package algorithms.medium

import java.util.*

// Complete the encryption function below.
fun encryption(s: String): String {
	val sqrtLen = Math.sqrt(s.length.toDouble())
	val floor = Math.floor(sqrtLen).toInt()
	val ceil = Math.ceil(sqrtLen).toInt()
	val col = ceil
	val row = if (floor * ceil >= s.length) floor else ceil

	val stringBuilder = StringBuilder()
	for (i in 0..(row * col - 1)) {
		val c = s.getOrNull((i % row) * col + (i / row))

		if (c == null) {
			stringBuilder.append(" ")
			continue
		}
		stringBuilder.append(c)

		if (i > 0 && (i + 1) % row == 0)
			stringBuilder.append(" ")
	}

	return stringBuilder.toString()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val s = scan.nextLine()

	val result = encryption(s)

	println(result)
}
