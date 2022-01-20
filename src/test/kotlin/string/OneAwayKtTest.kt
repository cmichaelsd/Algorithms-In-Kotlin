package string

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class OneAwayKtTest {
    companion object {
        private const val BASE_STRING = "pale"
    }

    @Test
    fun both_empty_strings() {
        val oneAway = "".oneAway("")
        assertTrue(oneAway)
    }

    @Test
    fun empty_string() {
        val oneAway = BASE_STRING.oneAway("")
        assertFalse(oneAway)
    }

    @Test
    fun one_char_away() {
        val oneAway = BASE_STRING.oneAway("bale")
        assertTrue(oneAway)
    }

    @Test
    fun many_chars_away() {
        val oneAway = BASE_STRING.oneAway("cookies")
        assertFalse(oneAway)
    }
}