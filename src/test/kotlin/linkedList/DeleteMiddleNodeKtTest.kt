package linkedList

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class DeleteMiddleNodeKtTest : BaseLinkedListTest() {
    @Test
    fun even_linked_list() {
        val root = createList(arrayListOf(1, 2, 3, 4, 5, 6)) ?: return
        val expected = createList(arrayListOf(1, 2, 4, 5, 6)) ?: return

        root.deleteMiddleNode()

        assertTrue(compareLists(expected, root))
    }

    @Test
    fun odd_linked_list() {
        val root = createList(arrayListOf(1, 2, 3, 4, 5)) ?: return
        val expected = createList(arrayListOf(1, 2, 4, 5)) ?: return

        root.deleteMiddleNode()

        assertTrue(compareLists(expected, root))
    }

    @Test
    fun single_node_list() {
        val root: ListNode<Int> = createList(arrayListOf(1)) ?: return
        val expected = createList(arrayListOf(1)) ?: return

        root.deleteMiddleNode()

        assertTrue(compareLists(expected, root))
    }

    @Test
    fun two_node_list() {
        val root = createList(arrayListOf(1, 2)) ?: return
        val expected = createList(arrayListOf(1)) ?: return

        root.deleteMiddleNode()

        assertTrue(compareLists(expected, root))
    }
}