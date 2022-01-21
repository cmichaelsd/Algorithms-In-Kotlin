package linkedList

fun <T> ListNode<T>.removeDups() {
    var S: ListNode<T>? = this
    while (S != null) {
        var E: ListNode<T>? = S
        while (E != null) {
            E.next?.let {
                if (S?.value == it.next?.value) {
                    it.next = it.next?.next
                }
            }
            E = E.next
        }
        S = S.next
    }
}