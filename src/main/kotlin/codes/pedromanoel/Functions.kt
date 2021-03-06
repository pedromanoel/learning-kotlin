package codes.pedromanoel

import java.lang.StringBuilder

/** Complete declaration */
fun upper1(value: String): String {
    return value.toUpperCase()
}

/** Single expression function */
fun upper2(value: String): String = value.toUpperCase()

/** Implicit return type */
fun upper3(value: String) = value.toUpperCase()

/** Lambda */
val upper4 = { value: String -> value.toUpperCase() }

/** Parameters with default values */
fun printPersonDetails(
    name: String = "<UNDEFINED>",
    age: Int = 0
) = "Name: $name, Age: ${if (age == 0) "<UNDEFINED>" else age.toString()}"

data class Text(val value: String) {
    /** Infix notation */
    infix fun concat(other: String) = value + other

    /** Using lambda as last parameter */
    fun transform(applyTransformTo: (String) -> String) =
        applyTransformTo(value)

    fun transformWrap(
        applyTransformTo: (String) -> String, prefix: String,
        suffix: String
    ) = prefix + applyTransformTo(value) + suffix

}

/** Varargs */
fun join(joinString: String, vararg values: String): String {
    val result = StringBuilder()

    for (i in values) {
        result.append(i)
        result.append(joinString)
    }

    return result.toString().removeSuffix(joinString)
}

/** Extension function */

fun String.wrapped(prefix: String, suffix: String) = prefix + this + suffix
