package linkedList

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class PalindromeKtTest : BaseLinkedListTest() {
    @Test
    fun valid_even_palindrome() {
        val root = createList(1, 2, 3, 3, 2, 1)
        val res = root.palindrome()
        assertTrue(res)
    }

    @Test
    fun valid_odd_palindrome() {
        val root = createList(1, 2, 3, 4, 3, 2, 1)
        val res = root.palindrome()
        assertTrue(res)
    }

    @Test
    fun invalid_palindrome() {
        val root = createList(1, 2, 3, 4, 2, 1)
        val res = root.palindrome()
        assertFalse(res)
    }
}