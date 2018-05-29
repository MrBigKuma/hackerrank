package algorithms.easy

import java.util.*

// Complete the maximumToys function below.
fun maximumToys(prices: Array<Int>, k: Int): Int {
	var total = 0
	var count = 0
	val sortedPrices = prices.sortedArray()
	while (total < k) {
		total += sortedPrices[count]
		count++
	}

	return count - 1
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nk = scan.nextLine().split(" ")

	val n = nk[0].trim().toInt()

	val k = nk[1].trim().toInt()

	val prices = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = maximumToys(prices, k)

	println(result)
}


