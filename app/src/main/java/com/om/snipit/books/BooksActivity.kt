package com.om.snipit.books

import android.os.Bundle
import android.widget.Toast
import com.om.snipit.R
import com.om.snipit.base.BaseActivity
import com.om.snipit.models.Book
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : BaseActivity(), BooksActivityPresenter.BooksActivityView {
  private val presenter = BooksActivityPresenter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_books)

    addBookToDBBTN.setOnClickListener {
      presenter.insertBook(Book(title = "Book 1", author = "Author 1", image_path = "testing 123",
          date_added = "24 December, 2017", color_code = 2, list_order = 2)
          , dbHelper, this)
    }
  }

  override fun notifySuccessfulInsertion() {
    Toast.makeText(this, "Successful insertion", Toast.LENGTH_SHORT).show()
  }

  override fun displayBooks(books: ArrayList<Book>) {
    TODO(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}