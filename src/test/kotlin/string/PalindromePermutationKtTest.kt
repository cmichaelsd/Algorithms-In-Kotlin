package string

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class PalindromePermutationKtTest {
    @Test
    fun invalid_permutation() {
        val palindromePermutation = "Rice Paper".palindromePermutation()
        assertFalse(palindromePermutation)
    }

    @Test
    fun valid_permutation() {
        val palindromePermutation = "Tact Coa".palindromePermutation()
        assertTrue(palindromePermutation)
    }

    @Test
    fun empty_string() {
        val palindromePermutation = "".palindromePermutation()
        assertTrue(palindromePermutation)
    }
}