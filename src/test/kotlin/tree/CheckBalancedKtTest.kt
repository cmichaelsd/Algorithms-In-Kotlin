package tree

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class CheckBalancedKtTest {
    @Test
    fun unbalanced_tree() {
        val tree = intArrayOf(1, 2, 3, 4).minimalTree() ?: return
        assertFalse(tree.checkBalanced())
    }

    @Test
    fun balanced_tree() {
        val tree = intArrayOf(1, 2, 3, 4, 5).minimalTree() ?: return
        assertTrue(tree.checkBalanced())
    }
}