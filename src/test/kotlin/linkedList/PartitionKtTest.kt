package linkedList

import kotlin.test.Test
import kotlin.test.assertTrue

internal class PartitionKtTest : BaseLinkedListTest() {
    @Test
    fun ideal_linked_list() {
        val root = createList(3, 5, 8, 5, 10, 2, 1)
        val expected = createList(3, 2, 1, 5, 8, 5, 10)

        root.partition(5)

        assertTrue(compareLists(expected, root))
    }

    @Test
    fun no_items_less_than_partition_value() {
        val root = createList(5, 6, 7, 8, 9, 10)
        val expected = createList(5, 6, 7, 8, 9, 10)

        root.partition(5)

        assertTrue(compareLists(expected, root))
    }

    @Test
    fun no_items_greater_than_partition_value() {
        val root = createList(1, 2, 3, 4)
        val expected = createList(1, 2, 3, 4)

        root.partition(5)

        assertTrue(compareLists(expected, root))
    }
}