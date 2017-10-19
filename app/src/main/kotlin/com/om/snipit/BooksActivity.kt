package com.om.snipit

import android.os.Bundle
import com.om.snipit.models.Book
import timber.log.Timber

class BooksActivity : BaseActivity(), BooksActivityPresenter.BooksActivityView {

  private val presenter = BooksActivityPresenter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_books)

    presenter.insertBook(
        Book(title = "Book 1", author = "Author 1", image_path = "testing 123",
            date_added = "24 December, 2017", color_code = 2, list_order = 2)
        , dbHelper)

    presenter.getBooks(this, dbHelper)
  }

  override fun displayBooks(books: ArrayList<Book>) {
    Timber.d("List of all books is : ${books.size}")
  }
}