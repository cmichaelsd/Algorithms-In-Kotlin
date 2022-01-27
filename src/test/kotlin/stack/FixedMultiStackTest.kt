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
        assertEquals(multiStack.peek(0), 5)
        assertEquals(multiStack.peek(1), 10)
        assertEquals(multiStack.peek(2), 15)

        multiStack.push(0, 100)

        assertEquals(multiStack.peek(0), 5)
    }

    @Test
    fun pop() {
        assertEquals(multiStack.pop(0), 5)
        assertEquals(multiStack.pop(1), 10)
        assertEquals(multiStack.pop(2), 15)

        for (i in 1..5) multiStack.pop(0)

        assertEquals(multiStack.pop(0), null)
    }

    @Test
    fun peek() {
        assertEquals(multiStack.peek(0), 5)
        assertEquals(multiStack.peek(1), 10)
        assertEquals(multiStack.peek(2), 15)

        for (i in 1..5) multiStack.pop(1)

        assertEquals(multiStack.pop(1), null)
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