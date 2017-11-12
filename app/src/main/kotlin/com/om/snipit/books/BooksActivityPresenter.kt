package com.om.snipit.books

import com.om.snipit.database.AppDatabase
import com.om.snipit.database.entities.Book
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BooksActivityPresenter {

  fun getBooks(view: BooksActivityView, database: AppDatabase) =
      database.bookDao().getAllBooks
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe { books ->
            view.displayBooks(books)
          }

  fun insertBook(book: Book, database: AppDatabase) =
      Single.fromCallable {
        database.bookDao()
            .insert(book)
      }
          .subscribeOn(Schedulers.newThread())
          .subscribe()


  interface BooksActivityView {
    fun displayBooks(books: MutableList<Book>)
  }
}