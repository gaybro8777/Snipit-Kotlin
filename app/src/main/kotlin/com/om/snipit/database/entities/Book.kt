package com.om.snipit.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.om.snipit.base.BOOK_TABLE_NAME

@Entity(tableName = BOOK_TABLE_NAME)

data class Book(@PrimaryKey(autoGenerate = true) var id: Long? = null,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "author") var author: String,
    @ColumnInfo(name = "image_path") var imagePath: String,
    @ColumnInfo(name = "date_added") var dateAdded: String,
    @ColumnInfo(name = "color_code") var colorCode: Int,
    @ColumnInfo(name = "list_order") var listOrder: Int)