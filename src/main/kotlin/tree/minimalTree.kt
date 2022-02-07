package tree

fun IntArray.minimalTree(): BSTNode? {
    fun recurse(L: Int, R: Int): BSTNode? {
        if (L > R) return null
        val M = (L + R).ushr(1)
        val root   = BSTNode(this[M])
        root.left  = recurse(L, M - 1)
        root.right = recurse(M + 1, R)
        return root
    }
    return recurse(0, this.size - 1)
}