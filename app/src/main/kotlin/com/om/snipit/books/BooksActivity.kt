package com.om.snipit.books

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import com.om.snipit.R
import com.om.snipit.base.BaseActivity
import com.om.snipit.models.Book
import com.om.snipit.ui.SimpleItemTouchHelperCallback
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : BaseActivity(), BooksActivityPresenter.BooksActivityView {

  private val presenter = BooksActivityPresenter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_books)

//    presenter.insertBook(
//        Book(title = "Book 1", author = "Author 1", image_path = "testing 123",
//            date_added = "24 December, 2017", color_code = 2, list_order = 2)
//        , dbHelper)

    presenter.getBooks(this, dbHelper)
  }

  override fun displayBooks(books: ArrayList<Book>) {
    val adapter = BooksRecyclerAdapter(books)

    booksRecyclerView.setHasFixedSize(true)
    booksRecyclerView.adapter = adapter
    booksRecyclerView.layoutManager = LinearLayoutManager(this)

    val callback = SimpleItemTouchHelperCallback(adapter)
    val itemTouchHelper = ItemTouchHelper(callback)
    itemTouchHelper.attachToRecyclerView(booksRecyclerView)
  }
}