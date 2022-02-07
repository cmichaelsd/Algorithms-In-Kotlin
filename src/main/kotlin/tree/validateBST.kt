package tree

fun BSTNode.validateBST(): Boolean {
    var valid = true
    fun recurse(node: BSTNode?) {
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