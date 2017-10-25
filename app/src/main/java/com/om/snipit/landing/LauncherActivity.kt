package com.om.snipit.landing

import android.content.Intent
import android.os.Bundle
import com.om.snipit.R
import com.om.snipit.USER_LOGGED_IN
import com.om.snipit.base.BaseActivity
import com.om.snipit.books.BooksActivity

class LauncherActivity : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_books)

    if (!prefs.getBoolean(USER_LOGGED_IN, false)) {
      startActivity(Intent(this, BooksActivity::class.java))
    } else {
//      startActivity(Intent(this, SnippetsActivity::class.java))
    }
  }
}
