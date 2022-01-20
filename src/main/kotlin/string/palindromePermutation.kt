package string

import java.util.*

/**
 * @return Boolean
 *
 * Returns true if the string is a permutation of a palindrome otherwise returns false.
 */
fun String.palindromePermutation(): Boolean {
    val lowerCase = this.lowercase(Locale.getDefault())
    var bitVector = 0
    for (c in lowerCase) {
        // Skip spaces
        if (c == ' ') continue

        val mask = 1 shl c.code
        // If bitVector and mask is zero
        bitVector = if (bitVector and mask == 0) {
            // Add bit
            bitVector or mask
        } else {
            // Remove bit
            bitVector and mask.inv()
        }
    }
    // If a number is odd 2^0 is always set to 1
    return bitVector == 0 || bitVector and (bitVector - 1) == 0
}