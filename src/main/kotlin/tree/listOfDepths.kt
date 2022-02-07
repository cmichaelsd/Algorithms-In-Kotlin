package tree

import java.util.*

fun BSTNode.listOfDepths(): Map<Int, LinkedList<Int>> {
    val map = mutableMapOf<Int, LinkedList<Int>>()
    val queue = ArrayDeque<Pair<BSTNode, Int>>().apply {
        addLast(Pair(this@listOfDepths, 0))
    }

    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()

        if (map[curr.second] != null) {
            map[curr.second]?.addLast(curr.first.value)
        } else {
            map[curr.second] = LinkedList<Int>().apply {
                addLast(curr.first.value)
            }
        }

        curr.first.left?.let { queue.addLast(Pair(it, curr.second + 1)) }
        curr.first.right?.let { queue.addLast(Pair(it, curr.second + 1)) }
    }

    return map
}