package linkedLists

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class RemoveDupsKtTest : BaseLinkedListTest() {
    @Test
    fun valid_linked_list() {
        val root = createList(arrayListOf(1, 2, 1, 3, 2)) ?: return
        val expected = createList(arrayListOf(1, 2, 3)) ?: return

        removeDups(root)

        assertTrue(compareLists(root, expected))
    }

    @Test
    fun invalid_result() {
        val root = createList(arrayListOf(1, 2, 1, 3, 2)) ?: return
        val expected = createList(arrayListOf(1, 2, 1, 3, 2)) ?: return

        removeDups(root)

        assertFalse(compareLists(root, expected))
    }
}