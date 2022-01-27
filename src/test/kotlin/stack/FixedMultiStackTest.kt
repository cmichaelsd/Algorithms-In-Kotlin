package stack

import kotlin.test.*

internal class FixedMultiStackTest {
    private val multiStack = FixedMultiStack(5, 3)

    @BeforeTest
    fun setup() {
        for (i in 1..3) {
            for (j in 1..5) {
                multiStack.push(i - 1, i * j)
            }
        }
    }

    @AfterTest
    fun teardown() {
        for (i in 1..3) {
            for (j in 1..5) {
                multiStack.pop(i - 1)
            }
        }
    }

    @Test
    fun push() {
        assertEquals(5, multiStack.peek(0))
        assertEquals(10, multiStack.peek(1))
        assertEquals(15, multiStack.peek(2))

        multiStack.push(0, 100)

        assertEquals(5, multiStack.peek(0))
    }

    @Test
    fun pop() {
        assertEquals(5, multiStack.pop(0))
        assertEquals(10, multiStack.pop(1))
        assertEquals(15, multiStack.pop(2))

        for (i in 1..5) multiStack.pop(0)

        assertEquals(null, multiStack.pop(0))
    }

    @Test
    fun peek() {
        assertEquals(5, multiStack.peek(0))
        assertEquals(10, multiStack.peek(1))
        assertEquals(15, multiStack.peek(2))

        for (i in 1..5) multiStack.pop(1)

        assertEquals(null, multiStack.pop(1))
    }

    @Test
    fun isEmpty() {
        assertFalse(multiStack.isEmpty(0))
        assertFalse(multiStack.isEmpty(1))
        assertFalse(multiStack.isEmpty(2))

        for (i in 1..5) multiStack.pop(0)

        assertTrue(multiStack.isEmpty(0))
    }

    @Test
    fun isNotEmpty() {
        assertTrue(multiStack.isNotEmpty(0))
        assertTrue(multiStack.isNotEmpty(1))
        assertTrue(multiStack.isNotEmpty(2))

        for (i in 1..5) multiStack.pop(0)

        assertFalse(multiStack.isNotEmpty(0))
    }
}