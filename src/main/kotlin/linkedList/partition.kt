package linkedList

fun ListNode<Int>.partition(value: Int): ListNode<Int>? {
    var lesserListHead: ListNode<Int>? = null
    var lesserListTail: ListNode<Int>? = null

    var greaterListHead: ListNode<Int>? = null
    var greaterListTail: ListNode<Int>? = null

    var curr: ListNode<Int>? = this
    while (curr != null) {
        val next: ListNode<Int>? = curr.next
        curr.next = null

        if (curr.value!! < value) {
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