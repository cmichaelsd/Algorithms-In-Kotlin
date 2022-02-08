package graph

import kotlin.test.*

internal class RouteBetweenNodesKtTest {
    private lateinit var graph: Graph

    @BeforeTest
    fun setup() {
        graph = Graph()
        val nodes = listOf("0", "1", "2", "3", "4")
        nodes.forEach { graph.addNode(it) }
    }

    @Test
    fun valid_directed_graph_and_nodes_connect() {
        val edges = listOf(
            listOf("0", "1"),
            listOf("0", "2"),
            listOf("0", "3"),
            listOf("1", "4"),
        )

        edges.forEach { graph.addDirectedEdge(it[0], it[1]) }

        val result = graph.routesBetweenNodes(graph.map["1"]!!, graph.map["4"]!!)

        assertTrue(result)
    }

    @Test
    fun valid_directed_graph_and_nodes_do_not_connect() {
        val edges = listOf(
            listOf("0", "1"),
            listOf("0", "2"),
            listOf("0", "3"),
            listOf("1", "4"),
        )

        val result = graph.routesBetweenNodes(graph.map["1"]!!, graph.map["3"]!!)

        assertFalse(result)
    }

    @Test
    fun edgeless_graph() {
        val result = graph.routesBetweenNodes(graph.map["0"]!!, graph.map["1"]!!)

        assertFalse(result)
    }
}