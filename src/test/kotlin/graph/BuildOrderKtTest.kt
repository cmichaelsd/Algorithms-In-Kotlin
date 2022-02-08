package graph

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertFailsWith

internal class BuildOrderKtTest {
    private val projects = listOf("a", "b", "c", "d", "e", "f")

    @Test
    fun directed_acyclic_graph() {
        val dependencies = listOf(
            listOf("a", "d"),
            listOf("b", "d"),
            listOf("d", "c"),
            listOf("f", "b"),
            listOf("f", "a")
        )
        val buildOrder = BuildOrder.topologicalSort(projects, dependencies)
        val result = mutableListOf<String>()
        buildOrder.forEach { result.add(it.data) }
        assertContentEquals(listOf("f", "e", "b", "a", "d", "c"), result)
    }

    @Test
    fun cyclic_graph() {
        val dependencies = listOf(
            listOf("a", "d"),
            listOf("b", "d"),
            listOf("d", "c"),
            listOf("f", "b"),
            listOf("f", "a"),
            listOf("d", "a")
        )

        assertFailsWith(
            Exception::class,
            "Not a directed acyclic graph.",
            block = {
                BuildOrder.topologicalSort(projects, dependencies)
            }
        )
    }
}