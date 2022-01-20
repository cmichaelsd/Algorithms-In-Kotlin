package string

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class CheckPermutationKtTest {
    companion object {
        private const val BASE_STRING = "abcd"
    }

    @Test
    fun both_strings_are_empty() {
        val checkPermutation = "".checkPermutation("")
        assertTrue(checkPermutation)
    }

    @Test
    fun empty_string() {
        val checkPermutation = BASE_STRING.checkPermutation("")
        assertFalse(checkPermutation)
    }

    @Test
    fun valid_permutation() {
        val checkPermutation = BASE_STRING.checkPermutation("adbc")
        assertTrue(checkPermutation)
    }

    @Test
    fun invalid_permutation() {
        val checkPermutation = BASE_STRING.checkPermutation("abce")
        assertFalse(checkPermutation)
    }
}