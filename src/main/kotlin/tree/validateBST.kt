package tree

fun TreeNode.validateBST(): Boolean {
    var valid = true
    fun recurse(node: TreeNode?) {
        if (node == null) return

        node.left?.let {
            if (it.value > node.value) {
                valid = false
                return
            }
        }

        recurse(node.left)

        node.right?.let {
            if (it.value < node.value) {
                valid = false
                return
            }
        }

        recurse(node.right)
    }
    recurse(this)

    return valid
}