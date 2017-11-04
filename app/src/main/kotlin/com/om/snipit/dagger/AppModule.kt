package com.om.snipit.dagger

import android.content.Context
import com.om.snipit.base.SnipitApp
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
  fun provideContext(): Context = app.applicationContext
}
