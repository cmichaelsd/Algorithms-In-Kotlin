package tree

data class BSTNode(
    val value: Int,
    var parent: BSTNode? = null,
    var left: BSTNode? = null,
    var right: BSTNode? = null
) {
    override fun toString(): String {
        return "(value: $value, left: $left, right: $right)"
    }
}
