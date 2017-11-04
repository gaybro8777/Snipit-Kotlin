package com.om.snipit.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.om.snipit.base.SNIPPET_TABLE_NAME

@Entity(tableName = SNIPPET_TABLE_NAME, foreignKeys = arrayOf(
    ForeignKey(entity = Book::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("book_id"))))

data class Snippet(@PrimaryKey(autoGenerate = true) val snippetId: Long = -1,
    @ColumnInfo(name = "book_id") val bookId: Int,
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "page_number") val page_number: Int = 0,
    @ColumnInfo(name = "image_path") val imagePath: String = "",
    @ColumnInfo(name = "aws_image_path") val awsImagePath: String = "",
    @ColumnInfo(name = "ocr_content") val ocrImage: String = "",
    @ColumnInfo(name = "date_added") val dateAdded: String = "",
    @ColumnInfo(name = "list_order") val listOrder: Int = 0,
    @ColumnInfo(name = "views") val views: Int = 0,
    @ColumnInfo(name = "note") val note: String = "",
    @ColumnInfo(name = "isNoteShowing") val isNoteShowing: Boolean = false,
    @ColumnInfo(name = "screen_name") val screenName: String = "")