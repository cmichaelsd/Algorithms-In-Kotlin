package array

import kotlin.test.Test
import kotlin.test.assertEquals

internal class ZeroMatrixKtTest {
    @Test
    fun empty_matrix() {
        val matrix = arrayListOf<ArrayList<Int>>()

        zeroMatrix(matrix)

        assertEquals(listOf(), matrix)
    }

    @Test
    fun rectangular_matrix() {
        val matrix = arrayListOf(
            arrayListOf(1, 1, 1, 1, 1),
            arrayListOf(2, 0, 2, 2, 2),
            arrayListOf(3, 3, 3, 0, 3),
            arrayListOf(4, 4, 4, 4, 4)
        )

        val expected = arrayListOf(
            arrayListOf(1, 0, 1, 0, 1),
            arrayListOf(0, 0, 0, 0, 0),
            arrayListOf(0, 0, 0, 0, 0),
            arrayListOf(4, 0, 4, 0, 4)
        )

        zeroMatrix(matrix)

        assertEquals(expected, matrix)
    }

    @Test
    fun square_matrix() {
        val matrix = arrayListOf(
            arrayListOf(1, 0, 3, 4, 5),
            arrayListOf(6, 7, 8, 9, 10),
            arrayListOf(11, 12, 0, 14, 15),
            arrayListOf(16, 17, 18, 19, 20),
            arrayListOf(21, 22, 23, 24, 25)
        )

        val expected = arrayListOf(
            arrayListOf(0, 0, 0, 0, 0),
            arrayListOf(6, 0, 0, 9, 10),
            arrayListOf(0, 0, 0, 0, 0),
            arrayListOf(16, 0, 0, 19, 20),
            arrayListOf(21, 0, 0, 24, 25)
        )

        zeroMatrix(matrix)

        assertEquals(expected, matrix)
    }
}