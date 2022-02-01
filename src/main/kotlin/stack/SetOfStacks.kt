package stack

class SetOfStacks<T>(private val capacity: Int) {
    private val list = mutableListOf<MutableList<T>>()

    val numberOfStacks get() = list.size

    val size get() = list.fold(0) { sum, sublist -> sum + sublist.size }

    fun push(value: T) {
        if (
            list.isEmpty() ||
            (numberOfStacks > 0 && list[numberOfStacks - 1].size == capacity)
        ) {
            list.add(mutableListOf())
        }

        list[numberOfStacks - 1].add(value)
    }

    fun pop(): T? {
        if (list.isEmpty()) return null
        val result = list[numberOfStacks - 1].removeLastOrNull()
        if (list[numberOfStacks - 1].isEmpty()) list.removeLastOrNull()
        return result
    }

    fun popAt(index: Int): T? {
        if (
            list.isEmpty() ||
            (index < 0 || index > numberOfStacks - 1)
        ) return null

        val result = list[index].removeLastOrNull()
        for (i in index + 1 until numberOfStacks) {
            val temp = removeFirst(i) ?: continue
            list[i - 1].add(temp)
        }
        return result
    }

    fun isNotEmpty(): Boolean = !isEmpty()

    fun isEmpty(): Boolean = list.isEmpty()

    private fun removeFirst(index: Int): T? {
        if (
            list.isEmpty() ||
            (index < 0 || index > numberOfStacks - 1)
        ) return null

        val result = list[index].removeFirstOrNull()
        if (list[index].isEmpty()) list.removeAt(index)
        return result
    }
}