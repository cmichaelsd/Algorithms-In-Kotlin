package linkedList

fun <T> ListNode<T>.deleteMiddleNode() {
    var S: ListNode<T>? = this
    var E: ListNode<T>? = this.next?.next

    while (E != null) {
        E = E.next?.next
        E?.let { S = S?.next }
    }

    S?.next = S?.next?.next
}