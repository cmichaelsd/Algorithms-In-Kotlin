package tree

fun TreeNode.checkSubtree(node: TreeNode): Boolean {
    val compare = this.find(node.value) ?: return false
    if (!check (compare, node)) return false

    val q1 = ArrayDeque<TreeNode>().apply { addLast(compare) }
    val q2 = ArrayDeque<TreeNode>().apply { addLast(node) }
    while (q1.isNotEmpty()) {
        var curr1 = q1.removeFirst()
        var curr2 = q2.removeFirst()

        if (!check(curr1, curr2)) return false

        if (curr1.left != null && curr2.right != null) {
            if (!check(curr1.left, curr2.left)) return false
            q1.addLast(curr1.left!!)
            q2.addLast(curr2.left!!)
        }

        if (curr1.right != null && curr2.right != null) {
            if (!check(curr1.right, curr2.right)) return false
            q1.addLast(curr1.right!!)
            q2.addLast(curr2.right!!)
        }
    }

    return true
}

private fun check(n1: TreeNode?, n2: TreeNode?): Boolean = when {
    n1 == null && n2 == null -> true
    n1 == null || n2 == null -> false
    else                     -> n1.value == n2.value
}