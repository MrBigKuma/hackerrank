package algorithms.easy

import java.util.*

// Complete the permutationEquation function below.
fun permutationEquation(p: Array<Int>): Array<Int> {
	val revIndexMap = p.withIndex()
			.map { (index, v) -> v to index + 1 }
			.toMap()
	return (1..p.size).map { revIndexMap[revIndexMap[it]!!]!! }.toTypedArray()
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val p = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = permutationEquation(p)

	println(result.joinToString("\n"))
}
