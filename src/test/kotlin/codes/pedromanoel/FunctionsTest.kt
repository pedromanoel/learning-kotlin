package codes.pedromanoel

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test


class FunctionsTest {

    @Test
    fun function_declarations() {
        assertThat(helloWorld())
            .isEqualTo("Hello World complete declaration")
        assertThat(helloWorldShortExplicitReturn())
            .isEqualTo("Hello World explicit return")
        assertThat(helloWorldShortImplicitReturn())
            .isEqualTo("Hello World implicit return")
    }
}