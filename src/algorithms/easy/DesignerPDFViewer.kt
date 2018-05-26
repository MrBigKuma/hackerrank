package algorithms.easy

import java.util.*

// Complete the designerPdfViewer function below.
fun designerPdfViewer(h: Array<Int>, word: String): Int {
	val heightMap = ('a'..'z').withIndex()
			.map { (index, c) -> c to h[index] }
			.toMap()

	val maxHeight = word.map { heightMap[it]!! }
			.max()!!

	return maxHeight * word.length
}

fun main(args: Array<String>) {
	val scan = Scanner(System.`in`)

	val h = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

	val word = scan.nextLine()

	val result = designerPdfViewer(h, word)

	println(result)
}


