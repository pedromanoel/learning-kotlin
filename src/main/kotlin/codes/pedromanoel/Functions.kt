package codes.pedromanoel

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

/** Infix notation */
infix fun String.concat(other: String) = this + other

/** Parameters with default values */
fun printPersonDetails(
    name: String = "<UNDEFINED>",
    age: Int = 0
) = "Name: $name, Age: ${if (age == 0) "<UNDEFINED>" else age.toString()}"