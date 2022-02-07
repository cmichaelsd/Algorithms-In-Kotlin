package tree

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class ValidateBSTKtTest {
    @Test
    fun valid_bst() {
        val tree = intArrayOf(1, 2, 3, 4, 5).minimalTree() ?: return
        assertTrue(tree.checkBalanced())
    }

    @Test
    fun invalid_bst() {
        val tree = intArrayOf(1, 10, 4, 5, 6, 2).minimalTree() ?: return
        assertFalse(tree.checkBalanced())
    }
}