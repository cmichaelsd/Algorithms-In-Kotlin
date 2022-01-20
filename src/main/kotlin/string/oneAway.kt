package string

import kotlin.math.abs

/**
 * @param  s the string to compare against
 * @return Boolean
 *
 * Returns true is the string is one away from comparison string otherwise returns false.
 */
fun String.oneAway(s: String): Boolean {
    if (abs(this.length - s.length) > 1) return false

    // Find longer string to iterate
    val long  = if (this.length > s.length) this else s
    val short = if (this.length < s.length) this else s

    var longIndex  = 0
    var shortIndex = 0
    var difference = 0
    while (longIndex < long.length - 1 && shortIndex < short.length - 1) {
        if (long[longIndex] != short[shortIndex]) {
            if (difference == 1) return false

            ++difference

            if (long.length == short.length) ++shortIndex
        } else {
            ++shortIndex
        }

        ++longIndex
    }

    return true
}