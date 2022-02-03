package graph

data class GraphNode<T>(
    val id: T,
    val edges: MutableList<T> = mutableListOf()
) {
    override fun toString(): String {
        return "(id: $id, edges: [${edges.joinToString(",")}])"
    }
}