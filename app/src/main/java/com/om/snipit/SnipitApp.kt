package com.om.snipit

import android.app.Application
import timber.log.Timber

class SnipitApp : Application() {

  val component: AppComponent by lazy {
    DaggerAppComponent
        .builder()
        .build()
  }

  override fun onCreate() {
    super.onCreate()
    component.inject(this)

    Timber.plant(Timber.DebugTree())
  }
}