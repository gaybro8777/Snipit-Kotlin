package com.om.snipit.base

import android.app.Activity
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.om.snipit.R
import com.om.snipit.dagger.BaseModule
import com.om.snipit.database.AppDatabase
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {
  @Inject lateinit var prefs: SharedPreferences
  @Inject lateinit var dbHelper: AppDatabase

  private val Activity.app: SnipitApp
    get() = application as SnipitApp

  private val component by lazy { app.component.plus(BaseModule(this)) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    component.inject(this)
  }

  fun setupToolbar(toolbar: Toolbar, toolbarTitle: String?, backEnabled: Boolean,
      bookColorCode: Int) {
    if (toolbarTitle == null) {
      toolbar.setTitle(R.string.app_name)
    } else {
      toolbar.title = toolbarTitle
    }

    setupToolbarColors(bookColorCode, toolbar)

    setSupportActionBar(toolbar)

    if (backEnabled) {
      supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
  }


  private fun setupToolbarColors(bookColorCode: Int, toolbar: Toolbar) {
    when (bookColorCode) {
      DEFAULT_ACTIVITY_TOOLBAR_COLORS -> {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          window.statusBarColor = ContextCompat.getColor(this, R.color.darker_green)
        }
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
      }
      OPEN_SOURCE_LIBS_ACTIVITY_TOOLBAR_COLORS -> {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          window.statusBarColor = ContextCompat.getColor(this, R.color.darker_purple)
        }
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.purple))
      }
      0 -> {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          window.statusBarColor = ContextCompat.getColor(this, R.color.darker_pink)
        }
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.pink))
      }
      1 -> {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          window.statusBarColor = ContextCompat.getColor(this, R.color.darker_red)
        }
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
      }
      2 -> {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          window.statusBarColor = ContextCompat.getColor(this, R.color.darker_purple)
        }
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.purple))
      }
      3 -> {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          window.statusBarColor = ContextCompat.getColor(this, R.color.darker_yellow)
        }
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow))
      }
      4 -> {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          window.statusBarColor = ContextCompat.getColor(this, R.color.darker_blue)
        }
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
      }
      5 -> {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          window.statusBarColor = ContextCompat.getColor(this, R.color.darker_brown)
        }
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.brown))
      }
    }
  }
}