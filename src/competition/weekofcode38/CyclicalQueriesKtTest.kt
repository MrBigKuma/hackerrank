package competition.weekofcode38

class CyclicalQueriesKtTest {

	@org.junit.Test
	fun main() {
		cyclicalQueries(5, arrayOf(1L, 1L, 1L, 1L, 1L), arrayOf(
				"1 1 5",
				"4, 2",
				"3, 2",
				"4, 2",
				"2, 1, 5",
				"2, 1, 5",
				"2, 1, 5",
				"3, 5",
				"3, 5",
				"3, 1"
		))
	}
}