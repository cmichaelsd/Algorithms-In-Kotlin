package tree

fun IntArray.minimalTree(): TreeNode? {
    fun recurse(L: Int, R: Int, prev: TreeNode?): TreeNode? {
        if (L > R) return null

        val M = (L + R).ushr(1)
        val root   = TreeNode(this[M])

        prev?.let { root.parent = it }

        root.left  = recurse(L, M - 1, root)
        root.right = recurse(M + 1, R, root)

        return root
    }
    return recurse(0, this.size - 1, null)
}