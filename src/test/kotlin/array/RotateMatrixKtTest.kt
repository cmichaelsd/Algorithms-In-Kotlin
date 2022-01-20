package array

import kotlin.test.Test
import kotlin.test.assertEquals

internal class RotateMatrixKtTest {
    @Test
    fun empty_matrix() {
        val matrix = arrayListOf<ArrayList<Int>>()

        rotateMatrix(matrix)

        assertEquals(listOf(), matrix)
    }

    @Test
    fun rectangular_matrix() {
        val matrix = arrayListOf(
            arrayListOf(1, 1, 1, 1, 1),
            arrayListOf(2, 2, 2, 2, 2),
            arrayListOf(3, 3, 3, 3, 3),
            arrayListOf(4, 4, 4, 4, 4)
        )

        rotateMatrix(matrix)

        assertEquals(matrix, matrix)
    }

    @Test
    fun valid_matrix() {
        val matrix = arrayListOf(
            arrayListOf(1, 2, 3, 4, 5),
            arrayListOf(6, 7, 8, 9, 10),
            arrayListOf(11, 12, 13, 14, 15),
            arrayListOf(16, 17, 18, 19, 20),
            arrayListOf(21, 22, 23, 24, 25)
        )

        val expected = arrayListOf(
            arrayListOf(21, 16, 11, 6, 1),
            arrayListOf(22, 17, 12, 7, 2),
            arrayListOf(23, 18, 13, 8, 3),
            arrayListOf(24, 19, 14, 9, 4),
            arrayListOf(25, 20, 15, 10, 5)
        )

        rotateMatrix(matrix)

        assertEquals(expected, matrix)
    }
}