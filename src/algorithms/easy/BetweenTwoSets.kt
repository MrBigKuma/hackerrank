package algorithms.easy

import java.util.*

fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
	// a & b is less than 100, brute force is ok ;)
	return (a.max()!!..b.min()!!).count { v ->
		a.all { v % it == 0 } && b.all { it % v == 0 }
	}
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nm = scan.nextLine().split(" ")

	val n = nm[0].trim().toInt()

	val m = nm[1].trim().toInt()

	val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val b = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val total = getTotalX(a, b)

	println(total)
}


