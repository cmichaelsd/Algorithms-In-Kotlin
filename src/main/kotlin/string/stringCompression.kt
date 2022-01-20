package string

/**
 * @return String
 *
 * Returns a compressed string but if original string is smaller the original string is returned.
 * Example: aabcccccaaa, a2b1c5a3
 */
fun String.stringCompression(): String {
    if (this.length <= 3) return this

    var count = 1
    var build = ""
    for (i in 1 until this.length) {
        if (this.length <= build.length) break

        if (this[i - 1] != this[i]) {
            build += "${this[i - 1]}$count"
            count = 0
        }

        ++count

        if (i == this.length - 1) {
            build += "${this[i]}$count"
        }
    }

    return if (this.length <= build.length) this else build
}