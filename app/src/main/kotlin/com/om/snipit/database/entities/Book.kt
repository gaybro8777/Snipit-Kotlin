package com.om.snipit.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.om.snipit.base.BOOK_TABLE_NAME

@Entity(tableName = BOOK_TABLE_NAME)

data class Book(@PrimaryKey(autoGenerate = true) val id: Long = -1,
    @ColumnInfo(name = "title") val title: String = "",
    @ColumnInfo(name = "author") val author: String = "",
    @ColumnInfo(name = "image_path") val imagePath: String = "",
    @ColumnInfo(name = "date_added") val dateAdded: String = "",
    @ColumnInfo(name = "color_code") val colorCode: Int = 0,
    @ColumnInfo(name = "list_order") val listOrder: Int = 0)