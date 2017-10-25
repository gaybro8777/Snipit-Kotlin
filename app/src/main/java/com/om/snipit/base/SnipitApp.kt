package com.om.snipit.base

import android.app.Application
import com.om.snipit.dagger.AppComponent
import com.om.snipit.dagger.DaggerAppComponent
import timber.log.Timber

class SnipitApp : Application() {

  val component: AppComponent by lazy {
    DaggerAppComponent.builder()
        .build()
  }

  override fun onCreate() {
    super.onCreate()
    component.inject(this)

    Timber.plant(Timber.DebugTree())
  }
}