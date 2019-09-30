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
    fun lambda_as_block() {
        val result = Text("lowercase").transform { s -> s.toUpperCase() }
        assertThat(result).isEqualTo("LOWERCASE")
    }

    @Test
    fun lambda_as_parameter() {
        val result = Text("UPPERCASE")
            .transform(applyTransformTo = { s -> s.toLowerCase() })
        assertThat(result).isEqualTo("uppercase")
    }

    @Test
    fun lambda_as_method_reference() {
        val result = Text("UPPERCASE").transform(String::toLowerCase)
        assertThat(result).isEqualTo("uppercase")
    }

    @Test
    fun lambda_with_other_params() {
        val result = Text("  table  ").transformWrap(String::trim, "<", ">")

        assertThat(result).isEqualTo("<table>")
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

    @Test
    fun varargs() {
        val result = join(" - ", "apple", "orange", "lemon")

        assertThat(result).isEqualTo("apple - orange - lemon")
    }

    @Test
    fun varargs_with_spread_operator() {
        val result = join(
            values = *arrayOf("one", "two", "three"),
            joinString = ", "
        )

        assertThat(result).isEqualTo("one, two, three")

    }
}