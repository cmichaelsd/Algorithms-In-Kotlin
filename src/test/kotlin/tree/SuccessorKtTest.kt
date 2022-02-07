package tree

import kotlin.test.Test
import kotlin.test.assertEquals

internal class SuccessorKtTest {
    private val list = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    private val tree = list.minimalTreeWithParent()

    @Test
    fun right_most_node() {
        val rightmost = tree?.getRightmost() ?: return
        val successor = rightmost.successor()
        assertEquals(null, successor)
    }

    @Test
    fun left_right_most_node() {
        val leftRightmost = tree?.left?.getRightmost() ?: return
        val successor = leftRightmost.successor()
        assertEquals(leftRightmost.value + 1, successor?.value)
    }

    @Test
    fun left_most_node() {
        val leftmost = tree?.getLeftmost() ?: return
        val successor = leftmost.successor()
        assertEquals(leftmost.value + 1, successor?.value)
    }

    @Test
    fun right_left_most_node() {
        val rightLeftmost = tree?.right?.getLeftmost() ?: return
        val successor = rightLeftmost.successor()
        assertEquals(rightLeftmost.value + 1, successor?.value)
    }

    @Test
    fun non_leaf_node() {
        val nonLeafNode = tree?.right?.getLeftmost()?.parent ?: return
        val successor = nonLeafNode.successor()
        assertEquals(nonLeafNode.value + 1, successor?.value)
    }

    private fun BSTNode.getLeftmost(): BSTNode {
        var left: BSTNode? = this.left
        while (left?.left != null) left = left.right
        return left!!
    }

    private fun BSTNode.getRightmost(): BSTNode {
        var right: BSTNode? = this.right
        while (right?.right != null) right = right.right
        return right!!
    }

    private fun IntArray.minimalTreeWithParent(): BSTNode? {
        fun recurse(L: Int, R: Int): BSTNode? {
            if (L > R) return null
            val M = (L + R).ushr(1)
            val root   = BSTNode(this[M])
            root.left  = recurse(L, M - 1)
            root.left?.parent = root
            root.right = recurse(M + 1, R)
            root.right?.parent = root
            return root
        }
        return recurse(0, this.size - 1)
    }
}