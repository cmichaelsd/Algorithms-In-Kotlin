package linkedList

import kotlin.math.abs

fun <T> ListNode<T>.intersection(list: ListNode<T>): ListNode<T>? {
    var length1 = 1
    var length2 = 1

    var S1: ListNode<T>? = this
    var S2: ListNode<T>? = list
    while (S1?.next != null || S2?.next != null) {
        S1?.next?.let {
            ++length1
            S1 = it
        }
        S2?.next?.let {
            ++length2
            S2 = it
        }
    }

    if (S1 !== S2) return null

    var long: ListNode<T>? = if (length1 > length2) this else list
    var short: ListNode<T>? = if (length1 < length2) this else list
    var diff = abs(length1 - length2)
    while (diff-- > 0) long = long?.next

    while (long != null) {
        if (long === short) break
        long = long?.next
        short = short?.next
    }

    return long
}