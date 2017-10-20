package com.om.snipit.dagger

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
  fun provideContext() = app.applicationContext
}
