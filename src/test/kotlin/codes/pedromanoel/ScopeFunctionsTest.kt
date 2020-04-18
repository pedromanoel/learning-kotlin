package codes.pedromanoel

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

const val NAME = "John"
const val AGE = 35

internal class ScopeFunctionsTest {

    private val contextObject = aPerson()

    @Nested
    @DisplayName("with()")
    inner class With {

        @Test
        fun `result is block return`() {
            val result: Any = with(contextObject) { age }

            assertEquals(AGE, result)
        }

        @Test
        fun `context object is referenced by this keyword`() {
            with(contextObject) {
                assertSame(contextObject, this)
            }
        }
    }

    @Nested
    @DisplayName("run()")
    inner class Run {

        @Test
        fun `result is block return`() {
            val result: Any = contextObject.run { age }

            assertSame(AGE, result)
        }

        @Test
        fun `context object is referenced by this keyword`() {
            contextObject.run { assertSame(contextObject, this) }
        }
    }

    @Nested
    @DisplayName("also()")
    inner class Also {
        fun `return is context object`() {
            val result: Any = contextObject.also { it.age }

            assertSame(contextObject, result)
        }
    }

}

fun aPerson() = Person(NAME, AGE)

data class Person(val name: String, val age: Int)