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
        assertThat(Text("One") concat "Two").isEqualTo("OneTwo")
        assertThat(Text("Three").concat("Four")).isEqualTo("ThreeFour")
    }

    @Test
    fun lambda_as_last_parameter() {
        val result1 = Text("lowercase")
            .transform { s -> s.toUpperCase() }
        assertThat(result1).isEqualTo("LOWERCASE")

        val result2 = Text("UPPERCASE")
            .transform(applyTransformTo = { s -> s.toLowerCase() })
        assertThat(result2).isEqualTo("uppercase")
    }

    @Test
    fun lambda_with_other_params() {
        val result1 =
            Text("td").transformWrap(String::toUpperCase, "<", ">")
        val result2 =
            Text("  table  ").transformWrap(String::trim, "<", ">")

        assertThat(result1).isEqualTo("<TD>")
        assertThat(result2).isEqualTo("<table>")
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