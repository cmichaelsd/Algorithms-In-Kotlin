package tree

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class CheckBalancedKtTest {
    @Test
    fun unbalanced_tree() {
        val list = intArrayOf(1, 2, 3, 4)
        val tree = minimalTree(list) ?: return
        assertFalse(tree.checkBalanced())
    }

    @Test
    fun balanced_tree() {
        val list = intArrayOf(1, 2, 3, 4, 5)
        val tree = minimalTree(list) ?: return
        assertTrue(tree.checkBalanced())
    }
}