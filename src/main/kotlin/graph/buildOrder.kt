package graph

fun buildOrder(nodes: List<Char>, edges: List<CharArray>): List<Char>? {
    val adj   = mutableMapOf<Char, MutableSet<Char>>()
    val seen  = mutableSetOf<Char>()
    val queue = ArrayDeque<Char>()
    nodes.forEach { adj[it] = mutableSetOf() }
    edges.forEach { adj[it[0]]?.add(it[1]) }

    // Find entry points
    for ((n1, v1) in adj) {
        var isNeighbor = false
        for ((n2, v2) in adj) {
            if (n1 == n2) continue
            if (n1 in adj[n2]!!) {
                isNeighbor = true
                break
            }
        }

        if (!isNeighbor) {
            seen.add(n1)
            queue.addLast(n1)
        }
    }

    val output = mutableListOf<Char>()
    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()

        output.add(curr)

        for (neighbor in adj[curr]!!) {
            if (neighbor !in seen) {
                queue.addLast(neighbor)
            }
        }
    }

    return output
}