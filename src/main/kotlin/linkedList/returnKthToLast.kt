package linkedList

fun returnKthToLast(head: ListNode, k: Int): ListNode? {
    var S: ListNode? = head
    var E: ListNode? = S
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