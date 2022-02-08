package graph

class Node(val data: String) {
    val neighbors = ArrayList<Node>()
    var status: Visited = Visited.NEW

    fun addDirectedNeighbor(neighbor: Node) {
        neighbors.add(neighbor)
    }
}