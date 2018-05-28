package algorithms.easy

import java.util.*

// Complete the fairRations function below.
fun fairRations(B: Array<Int>) {
	if (B.sum() % 2 == 1)
		print("NO")

	var count = 0
	for (i in 0 until B.size) {
		if (B[i] % 2 == 0)
			continue

		count++
		B[i + 1] += 1
	}

	print(count * 2)
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val N = scan.nextLine().trim().toInt()

	val B = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	fairRations(B)
}


