package algorithms.easy

import java.util.*
import kotlin.math.absoluteValue

fun bonAppetit(n: Int, k: Int, bills: Array<Int>, charged: Double): String {
	val actual = (bills.sum() - bills[k]).toDouble() / 2
	return if (actual == charged)
		"Bon Appetit"
	else
		(actual - charged).toInt().absoluteValue.toString()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nk = scan.nextLine().split(" ")

	val n = nk[0].trim().toInt()

	val k = nk[1].trim().toInt()

	val bills = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val charged = scan.nextLine().trim().toDouble()

	val result = bonAppetit(n, k, bills, charged)

	println(result)
}