package string

/**
 * @return String
 *
 * Returns a new string which all spaces are replaces with '%20'.
 */
fun String.urlify(): String {
    if (this.isBlank()) return this
    // Find number of spaces and times by two for extra escape characters.
    val n = this.count { it == ' ' } * 2
    // Create a new string with room for extra characters.
    val s = "$this${" ".repeat(n)}"
    // Create a char array to edit in place.
    val charArray = s.toCharArray()

    // ---- Only from this line onward counts for algo time complexity
    var tail = charArray.size
    // Iterate from original string length to index zero.
    for (i in this.length - 1 downTo 0) {
        // If current char is a space replace.
        if (charArray[i] == ' ') {
            // From the space to last two chars to escape pattern.
            charArray[tail - 1] = '0'
            charArray[tail - 2] = '2'
            charArray[tail - 3] = '%'
            // Decrease tail pointer.
            tail -= 3
        } else {
            // If current char is not space copy to the tail pointer of the char array.
            charArray[tail - 1] = charArray[i]
            // Decrease tail pointer.
            --tail
        }
    }

    return charArray.joinToString("")
}