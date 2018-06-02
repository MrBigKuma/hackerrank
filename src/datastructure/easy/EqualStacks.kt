package datastructure.easy

import java.util.*

fun equalStacks(h1: Array<Int>, h2: Array<Int>, h3: Array<Int>): Int {
	var maxEqualHeight = 0
	val stacks = arrayOf(h1, h2, h3)
	val hIndexes = arrayOf(h1.lastIndex, h2.lastIndex, h3.lastIndex)
	val stackHeights = Array(3, { 0 })

	for (i in 0 until stacks.sumBy { it.size }) {
		val minStackIndex = (0 until 3).minBy { stackHeights[it] }!!
		if (hIndexes[minStackIndex] == -1)
			break

		stackHeights[minStackIndex] = stackHeights[minStackIndex] + stacks[minStackIndex][hIndexes[minStackIndex]]
		hIndexes[minStackIndex]--

		if ((0 until 2).all { stackHeights[it] == stackHeights[it + 1] })
			maxEqualHeight = stackHeights[0]
	}

	return maxEqualHeight
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n1N2N3 = scan.nextLine().split(" ")

	val n1 = n1N2N3[0].trim().toInt()

	val n2 = n1N2N3[1].trim().toInt()

	val n3 = n1N2N3[2].trim().toInt()

	val h1 = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val h2 = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val h3 = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = equalStacks(h1, h2, h3)

	println(result)
}


