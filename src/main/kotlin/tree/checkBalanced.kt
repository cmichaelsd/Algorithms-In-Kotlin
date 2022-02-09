package tree

import java.util.concurrent.atomic.AtomicInteger

fun TreeNode.checkBalanced(): Boolean {
    val leftDepth  = AtomicInteger(0)
    val rightDepth = AtomicInteger(0)

    fun recurse(node: TreeNode?, depth: AtomicInteger) {
        if (node == null) return
        depth.incrementAndGet()
        recurse(node.left, depth)
        recurse(node.right, depth)
    }

    this.left?.let { recurse(this.left, leftDepth) }
    this.right?.let { recurse(this.right, rightDepth)}

    return leftDepth.get() == rightDepth.get()
}