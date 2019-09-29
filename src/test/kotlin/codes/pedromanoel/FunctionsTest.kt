package codes.pedromanoel

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test


class FunctionsTest {

    @Test
    fun different_function_declarations() {
        assertThat(upper1("complete")).isEqualTo("COMPLETE")

        assertThat(upper2("short")).isEqualTo("SHORT")

        assertThat(upper3("implicit return")).isEqualTo("IMPLICIT RETURN")

        assertThat(upper4("lambda")).isEqualTo("LAMBDA")
    }

    private fun upper1(value: String): String {
        return value.toUpperCase()
    }

    private fun upper2(value: String): String = value.toUpperCase()

    private fun upper3(value: String) = value.toUpperCase()

    val upper4 = { value: String -> value.toUpperCase() }

    @Test
    fun function_with_default_parameters() {
        val result1 = printPersonDetails()
        val result2 = printPersonDetails("Pedro", 35)

        assertThat(result1).isEqualTo("Name: <UNDEFINED>, Age: <UNDEFINED>")
        assertThat(result2).isEqualTo("Name: Pedro, Age: 35")
    }

    @Test
    fun named_parameters() {
        val result = printPersonDetails(age = 35, name = "Pedro")

        assertThat(result).isEqualTo("Name: Pedro, Age: 35")
    }

    private fun printPersonDetails(
        name: String = "<UNDEFINED>",
        age: Int = 0
    ) = "Name: $name, Age: ${if (age == 0) "<UNDEFINED>" else age.toString()}"
}