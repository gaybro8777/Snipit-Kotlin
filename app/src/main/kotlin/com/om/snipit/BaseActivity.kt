package com.om.snipit

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.om.snipit.dagger.BaseModule
import javax.inject.Inject

val Activity.app: SnipitApp
  get() = application as SnipitApp

open class BaseActivity : AppCompatActivity() {
  private val component by lazy { app.component.plus(BaseModule(this)) }

  @Inject lateinit var prefs: SharedPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    component.inject(this)
  }
}