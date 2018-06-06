package algorithms.easy

import java.util.*
import kotlin.math.min

// Complete the separateNumbers function below.
fun separateNumbers(s: String): Unit {
	(1..(s.length / 2)).forEach {
		val firstNum = s.substring(0, it).toBigInteger()
		var curNum = firstNum.inc()
		var idx = it
		do {
			val curStr = curNum.toString()
			val curLen = curStr.length
			if (curStr != s.substring(idx, min(s.length, idx + curLen)))
				break
			idx += curLen
			curNum++
		} while (idx < s.length)

		if (idx >= s.length) {
			println("YES $firstNum")
			return
		}

	}

	println("NO")
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val q = scan.nextLine().trim().toInt()

	for (qItr in 1..q) {
		val s = scan.nextLine()

		separateNumbers(s)
	}
}


