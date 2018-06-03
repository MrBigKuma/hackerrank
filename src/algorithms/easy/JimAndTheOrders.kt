package algorithms.easy

import java.util.*

// Complete the jimOrders function below.
fun jimOrders(orders: Array<Array<Int>>): Array<Int> {
	return orders.map { it[0] + it[1] }
			.withIndex()
			.sortedBy { it.value }
			.map { it.index + 1 }
			.toTypedArray()

}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val orders = Array<Array<Int>>(n, { Array<Int>(2, { 0 }) })

	for (i in 0 until n) {
		orders[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
	}

	val result = jimOrders(orders)

	println(result.joinToString(" "))
}


