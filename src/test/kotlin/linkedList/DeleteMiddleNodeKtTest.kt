package linkedList

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class DeleteMiddleNodeKtTest : BaseLinkedListTest() {
    @Test
    fun even_linked_list() {
        val root = createList(1, 2, 3, 4, 5, 6)
        val expected = createList(1, 2, 4, 5, 6)

        root.deleteMiddleNode()

        assertTrue(compareLists(expected, root))
    }

    @Test
    fun odd_linked_list() {
        val root = createList(1, 2, 3, 4, 5)
        val expected = createList(1, 2, 4, 5)

        root.deleteMiddleNode()

        assertTrue(compareLists(expected, root))
    }

    @Test
    fun single_node_list() {
        val root: ListNode<Int> = createList(1)
        val expected = createList(1)

        root.deleteMiddleNode()

        assertTrue(compareLists(expected, root))
    }

    @Test
    fun two_node_list() {
        val root = createList(1, 2)
        val expected = createList(1)

        root.deleteMiddleNode()

        assertTrue(compareLists(expected, root))
    }
}