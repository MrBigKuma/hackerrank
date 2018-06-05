package algorithms.easy

import java.util.*

// Complete the chocolateFeast function below.
fun chocolateFeast(n: Int, c: Int, m: Int): Int {
	var chocoNum = n / c
	var chocoWrapper = chocoNum
	while (chocoWrapper >= m) {
		val exchangeChocoNum = chocoWrapper / m
		chocoNum += exchangeChocoNum
		chocoWrapper = exchangeChocoNum + (chocoWrapper % m)
	}

	return chocoNum
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val t = scan.nextLine().trim().toInt()

	for (tItr in 1..t) {
		val ncm = scan.nextLine().split(" ")

		val n = ncm[0].trim().toInt()

		val c = ncm[1].trim().toInt()

		val m = ncm[2].trim().toInt()

		val result = chocolateFeast(n, c, m)

		println(result)
	}
}


