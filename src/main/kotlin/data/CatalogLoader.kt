package data

import kotlinx.coroutines.delay
import model.Book

suspend fun loadCatalog(): List<Book> {
    delay(300)

    return listOf(
        Book(1, "The Hobbit", "Fantasy", 310),
        Book(2, "Dune", "Science Fiction", 412),
        Book(3, "Pride and Prejudice", "Classic", 279),
        Book(4, "The Martian", "Science Fiction", 369)
    )
}