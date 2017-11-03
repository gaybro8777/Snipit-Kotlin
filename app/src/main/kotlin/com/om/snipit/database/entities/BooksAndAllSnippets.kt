package com.om.snipit.database.entities

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Query
import android.arch.persistence.room.Relation
import com.om.snipit.base.BOOK_TABLE_NAME

class BooksAndAllSnippets {
  @Embedded
  var book: Book? = null

  @Relation(parentColumn = "id", entityColumn = "book_id")
  var snippets: List<Snippet>? = null
}

@Dao
interface BookSnippetsDao {
  @Query("SELECT * from $BOOK_TABLE_NAME")
  fun loadBookAndSnippets(): List<BooksAndAllSnippets>
}