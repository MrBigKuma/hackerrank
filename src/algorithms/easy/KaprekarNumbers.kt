package algorithms.easy


import java.util.*

// Complete the kaprekarNumbers function below.
fun kaprekarNumbers(p: Int, q: Int): Array<Int> {
	return (p..q).filter {
		val sqrStr = (it.toLong() * it).toString()
		val splitIndex = sqrStr.length / 2
		val v1 = sqrStr.substring(0, splitIndex).toIntOrNull() ?: 0
		val v2 = sqrStr.substring(splitIndex).toIntOrNull() ?: 0
		v1 + v2 == it
	}.toTypedArray()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val p = scan.nextLine().trim().toInt()

	val q = scan.nextLine().trim().toInt()

	val result = kaprekarNumbers(p, q)

	if (result.isEmpty())
		print("INVALID RANGE")

	println(result.joinToString(" "))
}

