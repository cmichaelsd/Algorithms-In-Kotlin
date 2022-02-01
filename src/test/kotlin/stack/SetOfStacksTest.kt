package stack

import org.junit.jupiter.api.Test
import kotlin.test.*

internal class SetOfStacksTest {
    private val setOfStacks = SetOfStacks<Int>(5)

    @BeforeTest
    fun setup() {
        for (n in 1..23) setOfStacks.push(n)
    }

    @AfterTest
    fun teardown() {
        while (setOfStacks.isNotEmpty()) setOfStacks.pop()
    }

    @Test
    fun getNumberOfStacks() {
        assertEquals(5, setOfStacks.numberOfStacks)
    }

    @Test
    fun getSize() {
        assertEquals(23, setOfStacks.size)
    }

    @Test
    fun push() {
        val expected = mutableListOf<Int>()
        (23 downTo 1).forEach { expected.add(it) }
        val list = getAllItemsFromStack()
        assertContentEquals(expected, list)
    }

    @Test
    fun pop() {
        val expected = mutableListOf<Int>()
        (23 downTo 1).forEach { expected.add(it) }
        val list = getAllItemsFromStack()
        assertEquals(0, setOfStacks.size)
        assertEquals(0, setOfStacks.numberOfStacks)
        assertContentEquals(expected, list)
    }

    @Test
    fun popAt() {
        val expectedPoppedItems = listOf(20, 21, 22, 23, 19)
        val expectedRemainingStack = listOf(18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
        val list = mutableListOf<Int>()
        for (i in 1..5) {
            val temp = setOfStacks.popAt(3) ?: continue
            list.add(temp)
        }
        assertEquals(4, setOfStacks.numberOfStacks)
        assertEquals(expectedPoppedItems, list)
        assertEquals(expectedRemainingStack, getAllItemsFromStack())
    }

    @Test
    fun isEmpty() {
        assertFalse(setOfStacks.isEmpty())
        while (setOfStacks.isNotEmpty()) setOfStacks.pop()
        assertTrue(setOfStacks.isEmpty())
    }

    @Test
    fun isNotEmpty() {
        assertTrue(setOfStacks.isNotEmpty())
        while (setOfStacks.isNotEmpty()) setOfStacks.pop()
        assertFalse(setOfStacks.isNotEmpty())
    }

    private fun getAllItemsFromStack(): List<Int> {
        val list = mutableListOf<Int>()
        while (setOfStacks.isNotEmpty()) {
            setOfStacks.pop()?.let {
                list.add(it)
            }
        }
        return list
    }
}