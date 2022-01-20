package string

import kotlin.test.Test
import kotlin.test.assertEquals

internal class UrlifyKtTest {
    @Test
    fun empty_string() {
        val urlify = "".urlify()
        assertEquals("", urlify)
    }

    @Test
    fun valid_string() {
        val urlify = "Mr John Smith".urlify()
        assertEquals("Mr%20John%20Smith", urlify)
    }

    @Test
    fun string_with_no_spaces() {
        val urlify = "cats".urlify()
        assertEquals("cats", urlify)
    }
}