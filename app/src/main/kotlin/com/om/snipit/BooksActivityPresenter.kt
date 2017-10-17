package com.om.snipit

import com.om.snipit.models.Book
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync

class BooksActivityPresenter {
//  val view: BooksActivityView

  fun getBooks(): List<Book> {
    doAsync {
      bg {
        var allBooks : List<Book>


      }
    }
  }
}