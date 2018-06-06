package algorithms.easy

import java.util.*

// Complete the marsExploration function below.
fun marsExploration(s: String): Int {
	return (0 until s.length step 3).sumBy {
		var count = 0
		if (s[it] != 'S')
			count++
		if (s[it + 1] != 'O')
			count++
		if (s[it + 2] != 'S')
			count++
		count
	}

}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val s = scan.nextLine()

	val result = marsExploration(s)

	println(result)
}


