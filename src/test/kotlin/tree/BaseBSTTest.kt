package tree

abstract class BaseBSTTest {
    fun TreeNode.toInorderList(): IntArray {
        val list = mutableListOf<Int>()

        fun recurse(node: TreeNode?) {
            node ?: return
            recurse(node.left)
            list.add(node.value)
            recurse(node.right)
        }
        recurse(this)

        return list.toIntArray()
    }

    fun TreeNode.toLevelOrderList(): IntArray {
        val list  = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>().apply { addLast(this@toLevelOrderList) }
        while(queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            list.add(curr.value)
            curr.left?.let { queue.addLast(it) }
            curr.right?.let { queue.addLast(it) }
        }
        return list.toIntArray()
    }
}