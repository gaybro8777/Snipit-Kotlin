package com.om.snipit

import android.content.Intent
import android.os.Bundle

class LauncherActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (!prefs.getBoolean(USER_LOGGED_IN, false)) {
      startActivity(Intent(this, MainActivity::class.java))
    } else {
//      startActivity(Intent(this, LoginActivity::class.java))
    }
  }

  override fun onResume() {
    super.onResume()
    finish()
  }
}
