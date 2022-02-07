package tree

abstract class BaseBSTTest {
    fun BSTNode.toInorderList(): IntArray {
        val list = mutableListOf<Int>()

        fun recurse(node: BSTNode?) {
            node ?: return
            recurse(node.left)
            list.add(node.value)
            recurse(node.right)
        }
        recurse(this)

        return list.toIntArray()
    }

    fun BSTNode.toLevelOrderList(): IntArray {
        val list  = mutableListOf<Int>()
        val queue = ArrayDeque<BSTNode>().apply { addLast(this@toLevelOrderList) }
        while(queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            list.add(curr.value)
            curr.left?.let { queue.addLast(it) }
            curr.right?.let { queue.addLast(it) }
        }
        return list.toIntArray()
    }
}