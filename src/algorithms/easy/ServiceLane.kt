package algorithms.easy

import java.util.*

fun serviceLane(n: Int, width: Array<Int>, cases: Array<Array<Int>>): Array<Int> {

	return cases.map {
		val sIndex = it[0]
		val eIndex = it[1]
		width.copyOfRange(sIndex, eIndex + 1).min()!!
	}.toTypedArray()

}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val nt = scan.nextLine().split(" ")

	val n = nt[0].trim().toInt()

	val t = nt[1].trim().toInt()

	val width = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val cases = Array<Array<Int>>(t, { Array<Int>(2, { 0 }) })

	for (i in 0 until t) {
		cases[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
	}

	val result = serviceLane(n, width, cases)

	println(result.joinToString("\n"))
}


