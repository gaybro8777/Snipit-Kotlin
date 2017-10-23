package com.om.snipit

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

  val Activity.app: SnipitApp
    get() = application as SnipitApp

  val component by lazy { app.component.addComponent(BaseModule(this)) }

  @Inject lateinit var prefs: SharedPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    component.inject(this)

  }
}
