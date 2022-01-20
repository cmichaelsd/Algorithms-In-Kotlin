package string

fun String.stringRotation(s: String): Boolean = "$s$s".contains(this)