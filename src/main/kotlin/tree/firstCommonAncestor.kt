package tree

fun firstCommonAncestor(n1: TreeNode, n2: TreeNode): TreeNode? {
    if (n1 === n2) return n1

    var ancestor: TreeNode? = n1
    while (ancestor != null) {
        if (isOnPath(ancestor, n2)) return ancestor
        ancestor = ancestor.parent
    }

    return null
}

private fun isOnPath(ancestor: TreeNode, node: TreeNode): Boolean {
    var child: TreeNode? = node
    while (child != null) {
        if (ancestor === child) return true
        child = child.parent
    }
    return false
}