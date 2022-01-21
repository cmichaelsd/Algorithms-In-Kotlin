package linkedList

import kotlin.test.Test
import kotlin.test.assertEquals

internal class ReturnKthToLastKtTest : BaseLinkedListTest() {
    @Test
    fun valid_linked_list() {
        val root = createList(arrayListOf(1, 2, 3, 4, 5)) ?: return
        val kthNode = returnKthToLast(root, 2)?.value

        assertEquals(3, kthNode)
    }

    @Test
    fun single_node_link_list() {
        val root = createList(arrayListOf(1)) ?: return
        val kthNode = returnKthToLast(root, 0)?.value

        assertEquals(1, kthNode)
    }

    @Test
    fun k_is_larger_or_equal_to_list_size() {
        val root = createList(arrayListOf(1, 2, 3, 4, 5)) ?: return
        val kthNode1 = returnKthToLast(root, 5)?.value
        val kthNode2 = returnKthToLast(root, 100)?.value

        assertEquals(null, kthNode1)
        assertEquals(null, kthNode2)
    }
}