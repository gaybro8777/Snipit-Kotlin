package com.om.snipit.landing

import android.content.Intent
import android.os.Bundle
import com.om.snipit.base.BaseActivity
import com.om.snipit.books.BooksActivity

class LauncherActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

//    if (!prefs.getBoolean(USER_LOGGED_IN, false)) {
//      startActivity(Intent(this, LoginActivity::class.java))
//    } else {
      startActivity(Intent(this, BooksActivity::class.java))
//    }
  }

  override fun onResume() {
    super.onResume()
    finish()
  }
}
