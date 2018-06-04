package algorithms.easy

import java.util.*

// Complete the beautifulPairs function below.
fun beautifulPairs(A: Array<Int>, B: Array<Int>): Int {
	// TODO: Not complete
	val beautifulA = A.withIndex().filter { (index, a) ->
		B.any { b -> a == b }
	}
	val beautifulBCount = B.count { b ->
		A.any { a -> a == b }
	}

	var beautifulPairCount = beautifulA.toSet().size
	if (beautifulBCount > beautifulPairCount && beautifulA.size < A.size)
		beautifulPairCount++

	println(A.size)
	println(beautifulA.size)
	println(B.size)
	println(beautifulBCount)
	return beautifulPairCount
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val n = scan.nextLine().trim().toInt()

	val A = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val B = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val result = beautifulPairs(A, B)

	println(result)
}


