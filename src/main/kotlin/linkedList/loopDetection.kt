package linkedList

fun <T> ListNode<T>.loopDetection(): ListNode<T>? {
    var S: ListNode<T>? = this
    var E: ListNode<T>? = this
    while (E != null) {
        S = S?.next
        E = E.next?.next
        if (S === E) break
    }

    if (E == null) return null

    S = this
    while (S !== E) {
        S = S?.next
        E = E?.next
    }

    return E
}