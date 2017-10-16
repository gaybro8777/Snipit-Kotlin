package com.om.snipit.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class MySqlHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "snipit_db") {

  companion object {
    private var instance: MySqlHelper? = null

    @Synchronized
    fun getInstance(ctx: Context): MySqlHelper {
      if (instance == null) {
        instance = MySqlHelper(ctx.applicationContext)
      }
      return instance!!
    }

    val bookTableName: String = "Book"
    val snippetTableName: String = "Snippet"
  }

  override fun onCreate(db: SQLiteDatabase) {
    db.createTable(bookTableName, true,
        "id" to INTEGER + PRIMARY_KEY + UNIQUE,
        "title" to TEXT,
        "author" to TEXT,
        "image_path" to TEXT,
        "date_added" to TEXT,
        "color_code" to INTEGER,
        "order" to INTEGER
    )

    db.createTable(snippetTableName, true,
        "id" to INTEGER + PRIMARY_KEY + UNIQUE,
        "name" to TEXT,
        "page_number" to INTEGER,
        "image_path" to TEXT,
        "aws_image_path" to TEXT,
        "ocr_content" to TEXT,
        "date_added" to TEXT,
        "order" to INTEGER,
        "views" to INTEGER,
        "note" to TEXT,
        "isNoteShowing" to INTEGER
    )
  }

  override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
  }

}

// Access property for Context
val Context.database: MySqlHelper
  get() = MySqlHelper.getInstance(applicationContext)
