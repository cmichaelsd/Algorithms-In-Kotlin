package string

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class StringRotationKtTest {
    companion object {
        private const val BASE_STRING = "waterbottle"
        private const val ROTATED_STRING = "erbottlewat"
    }
    @Test
    fun both_empty_string() {
        val stringRotation = "".stringRotation("")
        assertTrue(stringRotation)
    }

    @Test
    fun empty_base_string() {
        val stringRotation = "".stringRotation(ROTATED_STRING)
        assertTrue(stringRotation)
    }

    @Test
    fun empty_rotated_string() {
        val stringRotation = BASE_STRING.stringRotation("")
        assertFalse(stringRotation)
    }

    @Test
    fun valid_strings() {
        val stringRotation = BASE_STRING.stringRotation(ROTATED_STRING)
        assertTrue(stringRotation)
    }
}