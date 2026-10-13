package model


data class Book(
    val id: Int,
    val title: String,
    val genre: String,
    val pages: Int,
    var isAvailable: Boolean = true
)