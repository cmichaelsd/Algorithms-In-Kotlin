package graph

import kotlin.test.Test
import kotlin.test.assertContentEquals

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
        assertContentEquals(listOf('e', 'f', 'b', 'a', 'd', 'c'), buildOrder)
    }

    @Test
    fun invalid_graph() {

    }
}