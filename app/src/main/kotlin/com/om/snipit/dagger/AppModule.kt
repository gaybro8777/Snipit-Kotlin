package com.om.snipit.dagger

import android.content.Context
import com.om.snipit.PREFS
import com.om.snipit.SnipitApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: SnipitApp) {
  @Provides
  @Singleton
  fun provideApp() = app

  @Provides
  @Singleton
  fun provideContext() = app.applicationContext

  @Provides
  @Singleton
  fun providesSharedPrefs() = app.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

}
