package algorithms.easy

import java.util.*

// Complete the gameOfThrones function below.
fun gameOfThrones(s: String): String {
	val charaterCountMap = mutableMapOf<Char, Int>()
	s.forEach {
		charaterCountMap.compute(it, { _, v ->
			v?.let { it + 1 } ?: 1
		})
	}

	val hasMoreThan1OddCharaterCount = charaterCountMap.filter { (_, count) -> count % 2 == 1 }
			.count() > 1
	return if (hasMoreThan1OddCharaterCount) "NO" else "YES"
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val s = scan.nextLine()

	val result = gameOfThrones(s)

	println(result)
}


