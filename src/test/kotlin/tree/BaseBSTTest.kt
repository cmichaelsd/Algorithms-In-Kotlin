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
}