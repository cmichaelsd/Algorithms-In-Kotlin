package graph

fun Graph.routesBetweenNodes(start: Node, end: Node): Boolean {
    if (start === end) return true

    val queue = ArrayDeque<Node>().apply { addLast(start) }
    start.status = Visited.DONE

    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()

        if (curr === end) return true

        for (neighbor in curr.neighbors) {
            if (neighbor.status != Visited.DONE) {
                neighbor.status = Visited.DONE
                queue.addLast(neighbor)
            }
        }
    }

    return false
}