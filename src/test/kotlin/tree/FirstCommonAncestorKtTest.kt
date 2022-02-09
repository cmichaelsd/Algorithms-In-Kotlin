package tree

import kotlin.test.Test
import kotlin.test.assertEquals

internal class FirstCommonAncestorKtTest {
    private val tree = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).minimalTree()
    @Test
    fun ancestor_exists() {
        val n1 = tree?.find(7) ?: return
        val n2 = tree.find(10) ?: return
        val result = tree.find(8) ?: return
        assertEquals(result, firstCommonAncestor(n1, n2))
    }

    @Test
    fun ancestor_does_not_exist() {
        val n1 = TreeNode(17)
        val n2 = tree?.find(4) ?: return
        assertEquals(null, firstCommonAncestor(n1, n2))
    }
}