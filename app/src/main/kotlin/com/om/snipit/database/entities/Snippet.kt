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

data class Snippet(@PrimaryKey(autoGenerate = true) val snippet_id: Long = -1,
    @ColumnInfo(name = "book_id") val book_id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "page_number") val page_number: Long,
    @ColumnInfo(name = "image_path") val image_path: String,
    @ColumnInfo(name = "aws_image_path") val aws_image_path: String,
    @ColumnInfo(name = "ocr_content") val ocr_content: String,
    @ColumnInfo(name = "date_added") val date_added: String,
    @ColumnInfo(name = "list_order") val list_order: Long,
    @ColumnInfo(name = "views") val views: Long,
    @ColumnInfo(name = "note") val note: String,
    @ColumnInfo(name = "isNoteShowing") val isNoteShowing: Boolean,
    @ColumnInfo(name = "screen_name") val screen_name: String)