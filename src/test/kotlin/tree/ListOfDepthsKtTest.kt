package tree

import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class ListOfDepthsKtTest : BaseBSTTest() {
    @Test
    fun large_tree() {
        val list = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        val tree = minimalTree(list) ?: return
        val map  = tree.listOfDepths()
        compareMapToList(map, tree.toLevelOrderList().toMutableList())
    }

    @Test
    fun small_tree() {
        val list = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val tree = minimalTree(list) ?: return
        val map  = tree.listOfDepths()
        compareMapToList(map, tree.toLevelOrderList().toMutableList())
    }

    private fun compareMapToList(map: Map<Int, LinkedList<Int>>, list: MutableList<Int>) {
        for ((key, value) in map) {
            for (item in value) {
                assertEquals(list.removeFirst(), item)
            }
        }
    }
}