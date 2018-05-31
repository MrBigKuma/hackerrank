package algorithms.easy

import java.util.*

// Complete the beautifulDays function below.
fun beautifulDays(i: Int, j: Int, k: Int): Int {
	if (9 % k == 0)
		return j - i + 1

	val powOf10 = arrayOf(1, 10, 100, 1000, 10000, 100000, 1000000, 10000000)

	return (i..j).count {
		val vStr = it.toString()
		vStr.map { it.toInt() }
				.withIndex()
				.map { (i, v) -> v * (powOf10[vStr.length - i - 1] - powOf10[i]) }
				.sum() % k == 0
	}

}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val ijk = scan.nextLine().split(" ")

	val i = ijk[0].trim().toInt()

	val j = ijk[1].trim().toInt()

	val k = ijk[2].trim().toInt()

	val result = beautifulDays(i, j, k)

	println(result)
}
