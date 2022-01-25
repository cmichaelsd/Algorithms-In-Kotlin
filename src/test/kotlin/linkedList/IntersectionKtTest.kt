package linkedList

import kotlin.test.Test
import kotlin.test.assertEquals

internal class IntersectionKtTest : BaseLinkedListTest() {
    @Test
    fun intersecting_list() {
        val root1 = createList(1, 2, 3, 4, 5)
        val intersection = root1.returnKthToLast(1)
        val root2 = createList(6, 7, 8).apply {
            next = intersection
        }
        val res = root1.intersection(root2)
        assertEquals(intersection, res)
    }

    @Test
    fun non_intersecting_list() {
        val root1 = createList(1, 2, 3, 4, 5)
        val root2 = createList(6, 7, 8)
        val res = root1.intersection(root2)
        assertEquals(null, res)
    }
}