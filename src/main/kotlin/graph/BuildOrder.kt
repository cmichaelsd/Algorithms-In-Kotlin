package graph

import java.util.*

object BuildOrder {
    @Throws(Exception::class)
    fun topologicalSort(projects: List<String>, edges: List<List<String>>): Deque<Node> {
        val graph = Graph()
        projects.forEach { graph.addNode(it) }
        edges.forEach { graph.addDirectedEdge(it[0], it[1]) }
        return topologicalSort(graph)
    }

    @Throws(Exception::class)
    fun topologicalSort(graph: Graph): Deque<Node> {
        val source = Node("Source")
        graph.nodes.forEach { source.addDirectedNeighbor(it) }

        val result = ArrayDeque<Node>()
        topologicalDFS(source, result)
        result.removeFirst()
        return result
    }

    @Throws(Exception::class)
    fun topologicalDFS(node: Node, result: Deque<Node>) {
        node.status = Visited.ACTIVE

        for (neighbor in node.neighbors) {
            if (neighbor.status == Visited.NEW) {
                topologicalDFS(neighbor, result)
            } else if (neighbor.status == Visited.ACTIVE) {
                throw Exception("Not a directed acyclic graph.")
            }
        }

        node.status = Visited.DONE
        result.addFirst(node)
    }
}

