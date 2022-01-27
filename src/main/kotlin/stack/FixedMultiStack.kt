package stack

class FixedMultiStack(
    private val size: Int,
    private val numberOfStacks: Int
) {
    private val sizes = Array<Int>(numberOfStacks) { 0 }
    private val stacks = Array<Int?>(size * numberOfStacks) { null }

    fun push(stack: Int, value: Int) {
        if (isFull(stack)) return
        stacks[tail(stack)] = value
        ++sizes[stack]
    }

    fun pop(stack: Int): Int? {
        if (isEmpty(stack)) return null
        --sizes[stack]
        val temp = stacks[tail(stack)]
        stacks[tail(stack)] = null
        return temp
    }

    fun peek(stack: Int): Int? {
        if (isEmpty(stack)) return null
        return stacks[tail(stack) - 1]
    }

    fun isEmpty(stack: Int): Boolean {
        if (stackIsNotInRange(stack)) return true
        return sizes[stack] == 0
    }

    fun isNotEmpty(stack: Int): Boolean {
        if (stackIsNotInRange(stack)) return true
        return !isEmpty(stack)
    }

    private fun isFull(stack: Int): Boolean {
        if (stackIsNotInRange(stack)) return true
        if (isEmpty(stack)) return false
        return sizes[stack] == size
    }

    private fun stackIsNotInRange(stack: Int): Boolean = !stackIsInRange(stack)

    private fun stackIsInRange(stack: Int): Boolean = stack in 0 until numberOfStacks

    private fun tail(stack: Int): Int = (stack * size) + sizes[stack]
}