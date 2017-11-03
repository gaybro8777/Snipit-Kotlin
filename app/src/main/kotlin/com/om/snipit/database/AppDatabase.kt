package com.om.snipit.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.om.snipit.database.daos.BookDao
import com.om.snipit.database.daos.SnippetDao
import com.om.snipit.database.entities.Book
import com.om.snipit.database.entities.Snippet

@Database(entities = arrayOf(Book::class, Snippet::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun bookDao(): BookDao
  abstract fun snippetDao(): SnippetDao
}