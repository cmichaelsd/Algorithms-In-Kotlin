package string

import kotlin.test.Test
import kotlin.test.assertEquals

internal class StringCompressionKtTest {
    @Test
    fun empty_string() {
        val stringCompression = "".stringCompression()
        assertEquals("", stringCompression)
    }

    @Test
    fun long_string() {
        val stringCompression = "aabcccccaaa".stringCompression()
        assertEquals("a2b1c5a3", stringCompression)
    }

    @Test
    fun short_string() {
        val stringCompression = "aab".stringCompression()
        assertEquals("aab", stringCompression)
    }

    @Test
    fun irregular_long_string() {
        val stringCompression = "abcdefghijk".stringCompression()
        assertEquals("abcdefghijk", stringCompression)
    }
}