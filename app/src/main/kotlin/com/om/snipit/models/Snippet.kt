package com.om.snipit.models

data class Snippet(val name: String, val page_number: Int, val image_path: String,
    val aws_image_path: String, val ocr_content: String, val date_added: String, val list_order: Int,
    val views: Int, val note: String, val isNoteShowing: Boolean, val screen_name: String)