package com.om.snipit

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.om.snipit.dagger.HomeModule
import javax.inject.Inject

class LauncherActivity : AppCompatActivity() {

  val Activity.app: SnipitApp
    get() = application as SnipitApp

  val component by lazy { app.component.plus(HomeModule(this)) }

  @Inject lateinit var prefs: SharedPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    component.inject(this)

    if (prefs.getBoolean(USER_LOGGED_IN, false)) {
//      startActivity(Intent(this, BooksActivity::class.java))
    } else {
//      startActivity(Intent(this, LoginActivity::class.java))
    }

  }

  override fun onResume() {
    super.onResume()
    finish()
  }
}
