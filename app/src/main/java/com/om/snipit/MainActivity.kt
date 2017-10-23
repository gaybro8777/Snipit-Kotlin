package com.om.snipit

import android.os.Bundle
import timber.log.Timber

class MainActivity : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    if (!prefs.getBoolean("FIRST_LAUNCH", false)) {
      Timber.d("First launch is false, we have access to prefs, yay!")
      prefs.edit().putBoolean("FIRST_LAUNCH", true).apply()
    } else {
      Timber.d("This is the first launch prefs works")
    }
  }
}
