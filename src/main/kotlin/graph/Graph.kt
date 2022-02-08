package graph

class Graph {
    val nodes = ArrayList<Node>()
    val map   = HashMap<String, Node>()

    fun addDirectedEdge(s1: String, s2: String) {
        val source      = map[s1] ?: return
        val destination = map[s2] ?: return
        source.addDirectedNeighbor(destination)
    }

    fun addNode(s: String) {
        val node = Node(s)
        nodes.add(node)
        map[s] = node
    }
}