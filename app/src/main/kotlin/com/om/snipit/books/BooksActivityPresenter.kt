package com.om.snipit.books

import com.om.snipit.database.AppDatabase
import com.om.snipit.database.entities.Book

class BooksActivityPresenter {
  fun getBooks(view: BooksActivityView, dbHelper: AppDatabase) = view.displayBooks(
      dbHelper.bookDao().all)

//  fun getBooks(view: BooksActivityView, dbHelper: DBHelper) {
//    dbHelper.doAsync {
//      bg {
//        val allBooks = ArrayList<Book>()
//
//        dbHelper.use {
//          select(DBHelper.BOOK_TABLE_NAME).parseList(object : MapRowParser<List<Book>> {
//
//            override fun parseRow(columns: Map<String, Any?>): ArrayList<Book> {
//
//              val _id = columns.getValue("_id") as Long
//              val title = columns.getValue("title") as String
//              val author = columns.getValue("author") as String
//              val image_path = columns.getValue("image_path") as String
//              val date_added = columns.getValue("date_added") as String
//              val color_code = columns.getValue("color_code") as Long
//              val order = columns.getValue("list_order") as Long
//
//              val book = Book(_id, title, author, image_path,
//                  date_added,
//                  color_code, order)
//
//              allBooks.add(book)
//
//              return allBooks
//            }
//          })
//
//          uiThread {
//            view.displayBooks(allBooks)
//          }
//        }
//      }
//    }
//  }

//  fun insertBook(book: Book, dbHelper: DBHelper) = dbHelper.doAsync {
//    bg {
//      dbHelper.use {
//        insert(DBHelper.BOOK_TABLE_NAME,
//            "title" to book.title,
//            "author" to book.author,
//            "image_path" to book.image_path,
//            "date_added" to book.date_added,
//            "color_code" to book.color_code,
//            "list_order" to book.list_order)
//      }
//    }
//  }

  interface BooksActivityView {
    fun displayBooks(books: ArrayList<Book>)
  }
}