package library

import model.Book
import model.BorrowResult

interface Borrowable {
    fun borrow(book: Book, member: String): BorrowResult
}