package library

import model.Book
import model.BorrowResult
import kotlin.collections.filter

class Library(
    val books: MutableList<Book>
) : Borrowable {

    override fun borrow(book: Book, member: String): BorrowResult {
        if (!book.isAvailable) {
            return BorrowResult.Error(
                "\"${book.title}\" is already borrowed."
            )
        }

        book.isAvailable = false

        return BorrowResult.Success(
            "$member borrowed \"${book.title}\"."
        )
    }

    fun availableBooks(): List<Book> {
        return books.filter { book -> book.isAvailable }
    }
}