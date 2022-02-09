package tree

fun TreeNode.successor(): TreeNode? {
    return if (this.right != null) this.right!!.leftMostChild()
    else this.properParent()
}

private fun TreeNode.leftMostChild(): TreeNode {
    var curr = this
    while (curr.left != null) curr = curr.left!!
    return curr
}

private fun TreeNode.properParent(): TreeNode? {
    var parent = this.parent
    var child  = this
    while (parent != null && parent.left != child) {
        child  = parent
        parent = child.parent
    }
    return parent
}