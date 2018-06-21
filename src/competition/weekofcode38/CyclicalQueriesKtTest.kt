package competition.weekofcode38

class CyclicalQueriesKtTest {

	@org.junit.Test
	fun main() {
		cyclicalQueries(5, arrayOf(1L, 1L, 1L, 1L, 1L), listOf(
				arrayOf(1, 1, 5),
				arrayOf(4, 2),
				arrayOf(3, 2),
				arrayOf(4, 2),
				arrayOf(2, 1, 5),
				arrayOf(3, 1)
		))
	}
}