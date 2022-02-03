package graph

fun routesBetweenNodes(n: Int, edges: List<IntArray>, n1: Int, n2: Int): Boolean {
    if (n == 0) return false

    val seen  = mutableSetOf<Int>()
    val map   = mutableMapOf<Int, GraphNode<Int>>()

    (0 until n).forEach { map[it] = GraphNode(it) }

    for (edge in edges) map[edge[0]]?.edges?.add(edge[1])

    val queue = ArrayDeque<GraphNode<Int>>().apply { addLast(map[0]!!) }
    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()

        seen.add(curr.id)

        for (neighbor in curr.edges) {
            if (neighbor in seen) continue
            if (curr.id == n1 && neighbor == n2) return true
            queue.addLast(map[neighbor]!!)
        }
    }

    return false
}