package com.om.snipit.books

import com.om.snipit.database.AppDatabase
import com.om.snipit.database.entities.Book
import kotlinx.coroutines.experimental.async

class BooksActivityPresenter {
  fun getBooks(view: BooksActivityView, dbHelper: AppDatabase)
  {
    view.displayBooks(mutableListOf(Book(title = "Book 1", author = "Author 1", imagePath = "testing 123",
            dateAdded = "24 December, 2017", colorCode = 2, listOrder = 2), Book(title = "Book 1", author = "Author 1", imagePath = "testing 123",
        dateAdded = "24 December, 2017", colorCode = 2, listOrder = 2), Book(title = "Book 1", author = "Author 1", imagePath = "testing 123",
        dateAdded = "24 December, 2017", colorCode = 2, listOrder = 2), Book(title = "Book 1", author = "Author 1", imagePath = "testing 123",
        dateAdded = "24 December, 2017", colorCode = 2, listOrder = 2)))
  }
//      = async {
//    val books = dbHelper.bookDao().all
//
//    view.displayBooks(books)
//  }

  fun insertBook(book: Book, dbHelper: AppDatabase) = async {
    dbHelper.bookDao().insert(book)
  }

  interface BooksActivityView {
    fun displayBooks(books: MutableList<Book>)
  }
}