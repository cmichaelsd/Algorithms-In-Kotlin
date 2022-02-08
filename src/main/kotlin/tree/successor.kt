package tree

fun BSTNode.successor(): BSTNode? {
    return if (this.right != null) this.right!!.leftMostChild()
    else this.properParent()
}

private fun BSTNode.leftMostChild(): BSTNode {
    var curr = this
    while (curr.left != null) curr = curr.left!!
    return curr
}

private fun BSTNode.properParent(): BSTNode? {
    var parent = this.parent
    var child  = this
    while (parent != null && parent.left != child) {
        child  = parent
        parent = child.parent
    }
    return parent
}