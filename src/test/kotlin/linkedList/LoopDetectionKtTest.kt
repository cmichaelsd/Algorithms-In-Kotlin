package linkedList

import kotlin.test.Test
import kotlin.test.assertEquals

internal class LoopDetectionKtTest : BaseLinkedListTest() {
    @Test
    fun looped_linked_list() {
        val root = createList(1, 2, 3, 4, 5, 6, 7)
        val tail = root.returnKthToLast(0)
        val loopedNode = root.returnKthToLast(3)
        tail?.next = loopedNode
        val res = root.loopDetection()
        assertEquals(loopedNode, res)
    }

    @Test
    fun non_looped_linked_list() {
        val root = createList(1, 2, 3, 4, 5, 6, 7)
        val res = root.loopDetection()
        assertEquals(null, res)
    }
}