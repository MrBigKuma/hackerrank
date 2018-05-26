package algorithms.medium

import java.util.*

// Complete the getMinimumCost function below.
fun getMinimumCost(n: Int, k: Int, c: Array<Int>): Int {
	val sortedPrices = c.copyOf()
	sortedPrices.sortDescending()

	var total = 0
	var priceIndex = 0
	var iterationIndex = 0
	while (priceIndex < n) {
		var personIndex = 0
		while (personIndex < k && priceIndex < n) {
			total += (iterationIndex + 1) * sortedPrices[priceIndex]
			personIndex++
			priceIndex++
		}
		iterationIndex++
	}

	return total
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nk = scan.nextLine().split(" ")

	val n = nk[0].trim().toInt()

	val k = nk[1].trim().toInt()

	val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val minimumCost = getMinimumCost(n, k, c)

	println(minimumCost)
}
