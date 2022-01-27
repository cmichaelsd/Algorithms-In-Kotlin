package stack

import java.util.*

class StackMin {
    private val list = LinkedList<MinNode>()

    fun push(value: Int) {
        val minNode = MinNode(value, if (list.isNotEmpty()) list.peek().min.coerceAtMost(value) else value)
        list.addLast(minNode)
    }
    fun pop(): Int = list.removeLast().value
    fun peek(): Int? = list.peekLast()?.value
    fun isEmpty(): Boolean = list.isEmpty()
    fun min(): Int? = list.peekLast()?.min

    inner class MinNode(val value: Int, val min: Int)
}