# Library Console

A small Kotlin/JVM console application that demonstrates a library catalog. It lists books and genres, tracks members, calculates the catalog’s total pages, and demonstrates borrowing a book.

## How to run

1. Open the project in IntelliJ IDEA as a Gradle project.
2. Wait for Gradle to sync and download the Kotlin Coroutines dependency.
3. Open `src/main/kotlin/Main.kt`.
4. Run the `main()` function. Output appears in IntelliJ’s Run window.


 Homework requirements
- Variables, data types, conditions, and loops: Main.kt and Library.kt
- List, Set, and Map: the book catalog, genres, and members in Main.kt
- map, filter, and reduce: collection operations in Main.kt
- Functions, higher-order functions, and lambdas: printBooks() in Main.kt
- Classes and objects: Book, Person, Member, and Library
- Inheritance: Member extends Person in model/Person.kt
- Interface and polymorphism: Borrowable and Library; Main.kt uses the library through the interface
- Data class: Book in model/Book.kt
- Sealed class: BorrowResult in model/BorrowResult.kt
- Suspend function and coroutine: loadCatalog() in data/CatalogLoader.kt, called with runBlocking in Main.kt
