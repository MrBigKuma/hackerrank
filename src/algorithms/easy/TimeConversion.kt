package algorithms.easy

import java.util.*

/*
 * Complete the timeConversion function below.
 */
fun timeConversion(s: String): String {
	val suffix = s.substring(8)
	val time12Str = s.substring(0, 8)
	val hour12 = time12Str.substring(0, 2).toInt()

	if (suffix == "AM") {
		if (hour12 == 12)
			return "00${time12Str.substring(2)}"

		return time12Str
	}

	if (hour12 == 12)
		return time12Str

	val hour24 = hour12 + 12
	return "$hour24${time12Str.substring(2)}"
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val s = scan.nextLine()

	val result = timeConversion(s)

	println(result)
}


