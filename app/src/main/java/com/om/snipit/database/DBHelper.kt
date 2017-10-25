package com.om.snipit.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DBHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "snipit_db") {
  override fun onCreate(db: SQLiteDatabase) {
    db.createTable(bookTableName, true,
        "_id" to INTEGER + PRIMARY_KEY + UNIQUE,
        "title" to TEXT,
        "author" to TEXT,
        "image_path" to TEXT,
        "date_added" to TEXT,
        "color_code" to INTEGER,
        "list_order" to INTEGER
    )
  }

  override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
  }

  companion object {
    val bookTableName: String = "Book"
    val snippetTableName: String = "Snippet"
  }
}