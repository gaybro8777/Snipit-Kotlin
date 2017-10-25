package com.om.snipit.books

import com.om.snipit.database.DBHelper
import com.om.snipit.models.Book
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.doAsync

class BooksActivityPresenter {

  fun insertBook(book: Book, dbHelper: DBHelper, view: BooksActivityView) = dbHelper.doAsync {
    bg {
      dbHelper.use {
        insert(DBHelper.bookTableName,
            "title" to book.title,
            "author" to book.author,
            "image_path" to book.image_path,
            "date_added" to book.date_added,
            "color_code" to book.color_code,
            "list_order" to book.list_order
        )
      }

//      uiThread { view.notifySuccessfulInsertion() }

      view.notifySuccessfulInsertion()
    }
  }

  interface BooksActivityView {
    fun displayBooks(books: ArrayList<Book>)

    fun notifySuccessfulInsertion()
  }
}