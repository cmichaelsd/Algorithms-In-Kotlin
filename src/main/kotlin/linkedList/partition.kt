package linkedList

fun <T> ListNode<T>.partition(predicate: (T?) -> Boolean): ListNode<T>? {
    var lesserListHead: ListNode<T>? = null
    var lesserListTail: ListNode<T>? = null

    var greaterListHead: ListNode<T>? = null
    var greaterListTail: ListNode<T>? = null

    var curr: ListNode<T>? = this
    while (curr != null) {
        val next: ListNode<T>? = curr.next
        curr.next = null

        if (predicate(curr.value)) {
            if (lesserListHead == null) {
                lesserListHead = curr
                lesserListTail = lesserListHead
            } else {
                lesserListTail?.next = curr
                lesserListTail = curr
            }
        } else {
            if (greaterListHead == null) {
                greaterListHead = curr
                greaterListTail = greaterListHead
            } else {
                greaterListTail?.next = curr
                greaterListTail = curr
            }
        }

        curr = next
    }

    if (lesserListHead == null) return greaterListHead

    lesserListTail?.next = greaterListHead

    return lesserListHead
}