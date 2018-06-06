package algorithms.easy

import java.util.*

// Complete the pangrams function below.
fun pangrams(s: String): String {
	val isPangram = s.filter { it != ' ' }.map { it.toLowerCase() }.toSet().size == 26
	return if(isPangram) "pangram" else "not pangram"
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val s = scan.nextLine()

	val result = pangrams(s)

	println(result)
}


