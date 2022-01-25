package linkedList

fun <T> ListNode<T>.palindrome(): Boolean {
    val stack = ArrayDeque<T>()

    var S: ListNode<T>? = this
    var E: ListNode<T>? = this
    while (E?.next != null) {
        S?.value?.let { stack.addLast(it) }
        S = S?.next
        E = E.next?.next
    }

    if (E != null) S = S?.next

    while (S != null) {
        val n = stack.removeLast()
        S.value?.let {
            if (it != n) return false
        }
        S = S.next
    }

    return true
}