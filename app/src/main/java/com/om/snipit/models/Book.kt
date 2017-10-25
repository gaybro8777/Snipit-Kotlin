package com.om.snipit.models

data class Book(val id: Long = -1, val title: String, val author: String, val image_path: String,
    val date_added: String,
    val color_code: Long, val list_order: Long)