package datastructure.easy

import java.util.*

fun leftRotation(d: Int, a: Array<Int>) {
	(0 until a.size).forEach {
		val v = a[(it + d) % a.size]
		print("$v ")
	}
}

fun leftRotationOriginal(d: Int, a: Array<Int>) {
	if (d == a.size)
		return

	var tmp: Int
	(0 until d).forEach {
		tmp = a[0]
		(0 until a.lastIndex).forEach {
			a[it] = a[it + 1 % a.size]
		}
		a[a.lastIndex] = tmp
	}

	print(a.joinToString(" "))
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nd = scan.nextLine().split(" ")

	val n = nd[0].trim().toInt()

	val d = nd[1].trim().toInt()

	val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	leftRotation(d, a)
}


