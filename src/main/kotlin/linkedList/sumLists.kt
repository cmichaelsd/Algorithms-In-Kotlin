package linkedList

fun ListNode<Int>.sumLists(list: ListNode<Int>): ListNode<Int> {
    val result = ListNode<Int>()
    var currResult: ListNode<Int>? = result

    var curr1: ListNode<Int>? = this
    var curr2: ListNode<Int>? = list
    var carry = 0
    while (curr1 != null || curr2 != null) {
        var sum = carry

        curr1?.value?.let { sum += it }
        curr2?.value?.let { sum += it }

        carry = sum / 10
        sum %= 10

        curr1 = curr1?.next
        curr2 = curr2?.next

        currResult?.next = ListNode(sum)
        currResult = currResult?.next
    }

    return result.next ?: ListNode()
}