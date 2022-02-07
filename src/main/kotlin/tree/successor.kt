package tree

fun BSTNode.successor(): BSTNode? {
    val source = this
    var right: BSTNode? = source.right
    while (right != null) {
        if (right.value == source.value + 1) return right
        right = right.right
    }

    var parent: BSTNode? = source.parent
    while (parent != null) {
        if (parent.value == source.value + 1) return parent
        parent = parent.parent
    }

    return null
}