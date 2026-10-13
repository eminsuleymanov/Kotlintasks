package model

open class Person(
    val name: String
)

class Member(
    val memberId: Int,
    name: String
) : Person(name)