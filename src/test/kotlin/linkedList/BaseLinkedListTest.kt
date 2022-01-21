package linkedList

abstract class BaseLinkedListTest {
    companion object {
        fun <T> createList(values: ArrayList<T>): ListNode<T>? {
            if (values.isEmpty()) return null

            val root = ListNode(values[0])
            var current: ListNode<T>? = root
            for (i in 1 until values.size) {
                val node = ListNode(values[i])
                current?.next = node
                current = current?.next
            }
            return root
        }

        fun <T> compareLists(r1: ListNode<T>?, r2: ListNode<T>?): Boolean {
            if (r1 == null && r2 == null) return true
            if (r1 == null || r2 == null) return false

            var c1 = r1
            var c2 = r2
            while (c1 != null || c2 != null) {
                if (c1?.value != c2?.value) return false
                c1 = c1?.next
                c2 = c2?.next
            }

            return true
        }
    }
}