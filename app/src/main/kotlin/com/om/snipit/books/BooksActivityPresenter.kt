package com.om.snipit.books

import com.om.snipit.database.AppDatabase
import com.om.snipit.database.entities.Book
import kotlinx.coroutines.experimental.async

class BooksActivityPresenter {
  fun getBooks(view: BooksActivityView, dbHelper: AppDatabase) = async {
    val books = dbHelper.bookDao().all

    view.displayBooks(books)
  }

  fun insertBook(book: Book, dbHelper: AppDatabase) = async {
    dbHelper.bookDao().insert(book)
  }

  interface BooksActivityView {
    fun displayBooks(books: MutableList<Book>)
  }
}