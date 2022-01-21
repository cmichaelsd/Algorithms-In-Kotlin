package linkedList

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class RemoveDupsKtTest : BaseLinkedListTest() {
    @Test
    fun valid_linked_list() {
        val root = createList(1, 2, 1, 3, 2)
        val expected = createList(1, 2, 3)

        root.removeDups()

        assertTrue(compareLists(root, expected))
    }

    @Test
    fun invalid_result() {
        val root = createList(1, 2, 1, 3, 2)
        val expected = createList(1, 2, 1, 3, 2)

        root.removeDups()

        assertFalse(compareLists(root, expected))
    }
}