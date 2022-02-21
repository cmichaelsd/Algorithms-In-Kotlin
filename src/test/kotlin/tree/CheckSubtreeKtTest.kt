package tree

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class CheckSubtreeKtTest {
    @Test
    fun valid_case() {
        val tree = intArrayOf(1, 2, 3, 4, 5, 6).minimalTree() ?: return
        val subtree = intArrayOf(4, 5, 6).minimalTree() ?: return
        assertTrue(tree.checkSubtree(subtree))
    }

    @Test
    fun invalid_case() {
        val tree = intArrayOf(1, 2, 3, 4, 5, 6).minimalTree() ?: return
        val subtree = intArrayOf(4, 5, 7).minimalTree() ?: return
        assertFalse(tree.checkSubtree(subtree))
    }
}