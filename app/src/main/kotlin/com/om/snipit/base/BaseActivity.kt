package com.om.snipit.base

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.om.snipit.dagger.BaseModule
import com.om.snipit.database.DBHelper
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {
  @Inject lateinit var prefs: SharedPreferences
  @Inject lateinit var dbHelper: DBHelper

  val Activity.app: SnipitApp
    get() = application as SnipitApp

  private val component by lazy { app.component.plus(BaseModule(this)) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    component.inject(this)
  }
}