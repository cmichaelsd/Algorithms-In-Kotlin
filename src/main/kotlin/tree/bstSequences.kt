package tree

import java.util.*

fun bstSequences(node: TreeNode?): List<Deque<Int>> {
    val result = ArrayList<Deque<Int>>()

    if (node == null) {
        result.add(ArrayDeque())
        return result
    }

    val prefix = ArrayDeque<Int>()
    prefix.add(node.value)

    val leftSequence = bstSequences(node.left)
    val rightSequence = bstSequences(node.right)

    for (left in leftSequence) {
        for (right in rightSequence) {
            val weaved = ArrayList<Deque<Int>>()
            weaveLists(left, right, weaved, prefix)
            result.addAll(weaved)
        }
    }

    return result
}

private fun weaveLists(
    l1: Deque<Int>,
    l2: Deque<Int>,
    results: MutableList<Deque<Int>>,
    prefix: Deque<Int>
) {
    if (l1.isEmpty() || l2.isEmpty()) {
        val result = ArrayDeque(prefix).apply {
            addAll(l1)
            addAll(l2)
        }
        results.add(result)
        return
    }

    var temp = l1.removeFirst()
    prefix.addLast(temp)
    weaveLists(l1, l2, results, prefix)
    prefix.removeLast()
    l1.addFirst(temp)

    temp = l2.removeFirst()
    prefix.addLast(temp)
    weaveLists(l1, l2, results, prefix)
    prefix.removeLast()
    l2.addFirst(temp)
}