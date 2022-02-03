package graph

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class RouteBetweenNodesKtTest {
    @Test
    fun valid_directed_graph_and_nodes_connect() {
        val routeBetweenNodes = routesBetweenNodes(
            5,
            listOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(0, 3),
                intArrayOf(1, 4)
            ),
            1,
            4
        )
        assertTrue(routeBetweenNodes)
    }

    @Test
    fun valid_directed_graph_and_nodes_do_not_connect() {
        val routeBetweenNodes = routesBetweenNodes(
            5,
            listOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(0, 3),
                intArrayOf(1, 4)
            ),
            1,
            3
        )
        assertFalse(routeBetweenNodes)
    }

    @Test
    fun empty_graph() {
        val routeBetweenNodes = routesBetweenNodes(
            0,
            listOf(),
            0,
            0
        )
        assertFalse(routeBetweenNodes)
    }
}