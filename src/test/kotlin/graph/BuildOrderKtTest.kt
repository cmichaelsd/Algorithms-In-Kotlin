package graph

import kotlin.test.Test

internal class BuildOrderKtTest {
    private val nodes = listOf<Char>('a', 'b', 'c', 'd', 'e', 'f')

    @Test
    fun valid_graph() {
        val edges = listOf(
            charArrayOf('a', 'd'),
            charArrayOf('b', 'd',),
            charArrayOf('d', 'c',),
            charArrayOf('f', 'b',),
            charArrayOf('f', 'a',)
        )
        val buildOrder = buildOrder(nodes, edges)
    }

    @Test
    fun invalid_graph() {

    }
}