package string

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class IsUniqueKtTest {
    @Test
    fun all_elements_not_unique() {
        val isUnique = "aaaabbbbcccddd".isUnique()
        assertFalse(isUnique)
    }

    @Test
    fun one_element_unique() {
        val isUnique = "aabcc".isUnique()
        assertFalse(isUnique)
    }

    @Test
    fun empty_string() {
        val isUnique = "".isUnique()
        assertTrue(isUnique)
    }

    @Test
    fun contains_all_unique() {
        val isUnique = "abcd".isUnique()
        assertTrue(isUnique)
    }
}