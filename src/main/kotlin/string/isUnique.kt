package string

/**
 * @return Boolean
 *
 * Returns true is a string contains all unique characters or is blank otherwise false.
 */
fun String.isUnique(): Boolean {
    var bitVector = 0
    for (c in this) {
        val mask = 1 shl c.code
        if ((bitVector and mask) != 0) return false
        bitVector = mask or bitVector
    }
    return true
}