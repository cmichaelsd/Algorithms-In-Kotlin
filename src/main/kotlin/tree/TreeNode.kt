package tree

data class TreeNode(
    val value: Int,
    var parent: TreeNode? = null,
    var left: TreeNode? = null,
    var right: TreeNode? = null
) {
    fun find(value: Int): TreeNode? {
        val queue = ArrayDeque<TreeNode>().apply { addLast(this@TreeNode) }
        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()

            if (curr.value == value) return curr

            curr.left?.let { queue.addLast(it) }
            curr.right?.let { queue.addLast(it) }
        }
        return null
    }

    override fun toString(): String {
        return "(value: $value, left: $left, right: $right)"
    }
}
