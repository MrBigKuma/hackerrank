package algorithms.easy

import java.util.*
import kotlin.math.absoluteValue

// Complete the catAndMouse function below.
fun catAndMouse(x: Int, y: Int, z: Int): String {
	val d1 = (z - x).absoluteValue
	val d2 = (z - y).absoluteValue


	if (d1 < d2)
		return "Cat A"

	if (d1 > d2)
		return "Cat B"

	return "Mouse C"
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val q = scan.nextLine().trim().toInt()

	for (qItr in 1..q) {
		val xyz = scan.nextLine().split(" ")

		val x = xyz[0].trim().toInt()

		val y = xyz[1].trim().toInt()

		val z = xyz[2].trim().toInt()

		val result = catAndMouse(x, y, z)

		println(result)
	}
}


