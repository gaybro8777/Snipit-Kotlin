package com.om.snipit.database.entities

import android.arch.persistence.room.*
import com.om.snipit.base.SNIPPET_TABLE_NAME

@Entity(tableName = SNIPPET_TABLE_NAME, foreignKeys = arrayOf(
    ForeignKey(entity = Book::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("book_id"))),
    indices = arrayOf(Index("book_id"))
)

data class Snippet(@PrimaryKey(autoGenerate = true) var snippetId: Long? = null,
    @ColumnInfo(name = "book_id") var bookId: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "page_number") var page_number: Int,
    @ColumnInfo(name = "image_path") var imagePath: String,
    @ColumnInfo(name = "aws_image_path") var awsImagePath: String,
    @ColumnInfo(name = "ocr_content") var ocrImage: String,
    @ColumnInfo(name = "date_added") var dateAdded: String,
    @ColumnInfo(name = "list_order") var listOrder: Int,
    @ColumnInfo(name = "views") var views: Int,
    @ColumnInfo(name = "note") var note: String,
    @ColumnInfo(name = "isNoteShowing") var isNoteShowing: Boolean = false,
    @ColumnInfo(name = "screen_name") var screenName: String)