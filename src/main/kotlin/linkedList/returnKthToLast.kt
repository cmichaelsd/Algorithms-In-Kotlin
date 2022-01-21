package linkedList

fun <T> ListNode<T>.returnKthToLast(k: Int): ListNode<T>? {
    var S: ListNode<T>? = this
    var E: ListNode<T>? = S
    for (i in 1..k) {
        E = E?.next
        if (E == null) return null // k is longer than list
    }

    while (E?.next != null) {
        E = E.next
        S = S?.next
    }

    return S
}