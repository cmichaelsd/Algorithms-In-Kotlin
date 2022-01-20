package linkedLists

fun removeDups(head: ListNode) {
    var S: ListNode? = head
    while (S != null) {

        var E: ListNode? = S
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