package stack

import java.sql.Time
import kotlin.random.Random
import kotlin.test.*

internal class StackMinTest {
    private val stackMin = StackMin()

    private var min: Int = Int.MIN_VALUE

    @BeforeTest
    fun setup() {
        for (i in 0..20) {
            val random = Random(System.currentTimeMillis())
            stackMin.push(random.nextInt())
        }

        min = stackMin.min() ?: Int.MIN_VALUE
    }

    @Test
    fun push() {
        stackMin.push(1)
        assertEquals(1, stackMin.peek())
    }

    @Test
    fun pop() {
        stackMin.push(1)
        assertEquals(1, stackMin.pop())
    }

    @Test
    fun peek() {
        stackMin.push(1)
        assertEquals(1, stackMin.peek())
    }

    @Test
    fun isEmpty() {
        assertFalse(stackMin.isEmpty())
        while (!stackMin.isEmpty()) stackMin.pop()
        assertTrue(stackMin.isEmpty())
    }

    @Test
    fun min() {
        assertEquals(min, stackMin.min())
    }
}