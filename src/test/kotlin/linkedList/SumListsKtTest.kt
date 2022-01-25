package linkedList

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class SumListsKtTest : BaseLinkedListTest() {
    @Test
    fun equal_length_lists() {
        val list1 = createList(7, 1, 6)
        val list2 = createList(5, 9, 2)
        val expected = createList(2, 1, 9)

        val result = list1.sumLists(list2)

        assertTrue(compareLists(expected, result))
    }

    @Test
    fun list_one_is_smaller() {
        val list1 = createList(1, 2)
        val list2 = createList(1, 2, 3)
        val expected = createList(2, 4, 3)

        val result = list1.sumLists(list2)

        assertTrue(compareLists(expected, result))
    }

    @Test
    fun list_two_is_smaller() {
        val list1 = createList(1, 2, 3)
        val list2 = createList(1, 2)
        val expected = createList(2, 4, 3)

        val result = list1.sumLists(list2)

        assertTrue(compareLists(expected, result))
    }
}