package com.om.snipit.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.om.snipit.base.BOOK_TABLE_NAME
import com.om.snipit.database.entities.Book
import io.reactivex.Flowable

@Dao
interface BookDao {
  @get:Query("SELECT * FROM $BOOK_TABLE_NAME")
  val getAllBooks: Flowable<MutableList<Book>>

  @Query("SELECT * FROM $BOOK_TABLE_NAME WHERE id IN (:bookIds)")
  fun loadAllByIds(bookIds: IntArray): Flowable<MutableList<Book>>

  @Query("SELECT * FROM $BOOK_TABLE_NAME WHERE title LIKE :title LIMIT 1")
  fun findByName(title: String): Flowable<Book>

  @Insert
  fun insert(book: Book)

  @Delete
  fun delete(book: Book)
}