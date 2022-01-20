package string

/**
 * @param  s the string to compare against for permutation.
 * @return Boolean
 *
 * Returns true is the string is a permutation of s otherwise false.
 */
fun String.checkPermutation(s: String): Boolean {
    if (this.length != s.length) return false

    val map = mutableMapOf<Char, Int>()
    for (c in this) {
        map[c] = map.getOrDefault(c, 0) + 1
    }

    for (c in s) {
        map[c]?.let {
            map[c] = it - 1
            if (it < 0) return false
        } ?: return false
    }

    return true
}