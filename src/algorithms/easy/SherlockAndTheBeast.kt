package algorithms.easy


import java.util.*

fun printLargestDecentNumber53(n: Int) {
	val num3Count = (0..n step 5).find { (n - it) % 3 == 0 }

	if (num3Count == null) {
		print(-1)
		return
	}

	(0 until (n - num3Count)).forEach { print("5") }
	(0 until num3Count).forEach { print("3") }
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val t = scan.nextLine().trim().toInt()

	for (tItr in 1..t) {
		val n = scan.nextLine().trim().toInt()
		printLargestDecentNumber53(n)
		println()
	}
}

