import data.loadCatalog
import kotlinx.coroutines.runBlocking
import library.Borrowable
import library.Library
import model.BorrowResult
import model.Member
import kotlin.collections.map

fun main() = runBlocking {
    // Variables and data types
    val books = loadCatalog()
    val library = Library(books.toMutableList())

    // Set: unique genres found in the catalog
    val genres: Set<String> = books.map { it.genre }.toSet()

    // Map: member ID mapped to a member object
    val members: Map<Int, Member> = mapOf(
        101 to Member(101, "Alex"),
        102 to Member(102, "Sam")
    )

    println("=== Library Console ===")

    println("\nGenres:")
    for (genre in genres) {
        println("- $genre")
    }

    println("\nMembers:")
    for ((id, member) in members) {
        println("$id: ${member.name}")
    }

    // filter: select available books
    val availableBooks = books.filter { it.isAvailable }

    println("\nAvailable books:")
    for (book in availableBooks) {
        println("${book.title} — ${book.genre}, ${book.pages} pages")
    }

    // map: get the titles
    val titles = books.map { it.title }
    println("\nBook titles: $titles")

    // reduce: calculate the total number of pages
    val totalPages = books
        .map { it.pages }
        .reduce { total, pages -> total + pages }

    println("Total pages in catalog: $totalPages")

    // A higher-order function takes another function as an argument.
    printBooks(books) { book ->
        "${book.title} (${book.pages} pages)"
    }

    // Use the interface type to demonstrate polymorphism.
    val lendingService: Borrowable = library
    val member = members[101]!!

    println("\nBorrowing a book:")
    val result = lendingService.borrow(books[0], member.name)
    printBorrowResult(result)

    println("\nTrying to borrow the same book again:")
    val secondResult = lendingService.borrow(books[0], member.name)
    printBorrowResult(secondResult)

    println("\nAvailable after borrowing:")
    for (book in library.availableBooks()) {
        println(book.title)
    }
}

// This function accepts a lambda that formats each book.
fun printBooks(
    books: List<model.Book>,
    formatter: (model.Book) -> String
) {
    println("\nFormatted book list:")
    for (book in books) {
        if (book.isAvailable) {
            println(formatter(book))
        }
    }
}

fun printBorrowResult(result: BorrowResult) {
    when (result) {
        is BorrowResult.Success -> println("Success: ${result.message}")
        is BorrowResult.Error -> println("Error: ${result.message}")
    }
}