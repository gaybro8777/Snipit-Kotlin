package com.om.snipit.books

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import com.om.snipit.R
import com.om.snipit.base.BaseActivity
import com.om.snipit.base.DEFAULT_ACTIVITY_TOOLBAR_COLORS
import com.om.snipit.books.touchhelper.SimpleItemTouchHelperCallback
import com.om.snipit.database.entities.Book
import kotlinx.android.synthetic.main.activity_books.*
import kotlinx.android.synthetic.main.toolbar.*

class BooksActivity : BaseActivity(), BooksActivityPresenter.BooksActivityView {
  private val presenter = BooksActivityPresenter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_books)

    setupToolbar(toolbar, null, false, DEFAULT_ACTIVITY_TOOLBAR_COLORS)

//    presenter.insertBook(
//        Book(title = "Book 1", author = "Author 1", imagePath = "testing 123",
//            dateAdded = "24 December, 2017", colorCode = 2, listOrder = 2)
//        , dbHelper)
//
    presenter.getBooks(this, dbHelper)
  }

  override fun displayBooks(books: MutableList<Book>) {
    val adapter = BooksRecyclerAdapter(books)

    booksRecyclerView.setHasFixedSize(true)
    booksRecyclerView.adapter = adapter
    booksRecyclerView.layoutManager = LinearLayoutManager(this)

    val callback: ItemTouchHelper.Callback = SimpleItemTouchHelperCallback(adapter)
    val itemTouchHelper = ItemTouchHelper(callback)
    itemTouchHelper.attachToRecyclerView(booksRecyclerView)
  }
}