package com.om.snipit.models

data class Book(val id: Int = -1, val title: String, val author: String, val image_path: String,
    val date_added: String,
    val color_code: Int, val list_order: Int)