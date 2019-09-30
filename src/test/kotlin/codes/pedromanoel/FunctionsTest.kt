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

    @Test
    fun infix_notation() {
        assertThat("One" concat "Two").isEqualTo("OneTwo")
        assertThat("Three".concat("Four")).isEqualTo("ThreeFour")
    }

    @Test
    fun passing_parameters() {
        val result = printPersonDetails("John Snow", 24)

        assertThat(result).isEqualTo("Name: John Snow, Age: 24")
    }

    @Test
    fun named_parameters() {
        val result = printPersonDetails(age = 35, name = "Pedro")

        assertThat(result).isEqualTo("Name: Pedro, Age: 35")
    }

    @Test
    fun using_default_parameters() {
        val result = printPersonDetails()

        assertThat(result).isEqualTo("Name: <UNDEFINED>, Age: <UNDEFINED>")
    }
}