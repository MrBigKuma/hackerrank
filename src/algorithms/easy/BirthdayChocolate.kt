package algorithms.easy

import java.util.*

// Complete the solve function below.
fun solveBirthdayChocolateConsecutive(n: Int, s: Array<Int>, d: Int, m: Int): Int {
	return (0..n - m).count {
		(it until it + m).sumBy { s[it] } == d
	}
}

fun countBirthdayChocolateNonConsecutive(s: Array<Int>, sIndex: Int, d: Int, m: Int): Int {
	if (d < 0)
		return 0

	if (d == 0) {
		if (m == 0)
			return 1
		else
			return 0
	}

	if (m == 0)
		return 0

	return (sIndex + 1 until s.size).sumBy {
		countBirthdayChocolateNonConsecutive(s, it, d - s[sIndex], m - 1)
	}
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val s = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val dm = scan.nextLine().split(" ")

	val d = dm[0].trim().toInt()

	val m = dm[1].trim().toInt()

	val result = solveBirthdayChocolateConsecutive(n, s, d, m)

	println(result)
}


