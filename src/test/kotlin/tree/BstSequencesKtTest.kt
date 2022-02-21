package tree

import kotlin.math.exp
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

internal class BstSequencesKtTest {
    @Test
    fun valid_bst() {
        val tree = intArrayOf(1, 2, 3, 4, 5).minimalTree()
        val expected = listOf(
            listOf(3, 1, 2, 4, 5),
            listOf(3, 1, 4, 2, 5),
            listOf(3, 1, 4, 5, 2),
            listOf(3, 4, 1, 2, 5),
            listOf(3, 4, 1, 5, 2),
            listOf(3, 4, 5, 1, 2)
        )

        val results = bstSequences(tree)

        if (results.size != expected.size) {
            assertEquals(expected.size, results.size)
            return
        }

        for (i in results.indices) {
            assertContentEquals(expected[i], results[i])
        }
    }
}