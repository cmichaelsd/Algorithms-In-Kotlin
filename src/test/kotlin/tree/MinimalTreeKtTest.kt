package tree

import kotlin.test.Test
import kotlin.test.assertContentEquals

internal class MinimalTreeKtTest : BaseBSTTest() {
    @Test
    fun small_sorted_list() {
        val list = intArrayOf(1, 2, 3)
        val minimalTree = minimalTree(list)
        assertContentEquals(list, minimalTree?.toInorderList())
    }

    @Test
    fun large_sorted_list() {
        val list = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val minimalTree = minimalTree(list)
        assertContentEquals(list, minimalTree?.toInorderList())
    }

    @Test
    fun odd_sorted_list() {
        val list = intArrayOf(1, 2, 3, 4)
        val minimalTree = minimalTree(list)
        assertContentEquals(list, minimalTree?.toInorderList())
    }

    @Test
    fun even_sorted_list() {
        val list = intArrayOf(1, 2, 3, 4, 5)
        val minimalTree = minimalTree(list)
        assertContentEquals(list, minimalTree?.toInorderList())
    }
}