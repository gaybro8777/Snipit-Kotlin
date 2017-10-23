package com.om.snipit

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: SnipitApp) {
  @Provides
  @Singleton
  fun provideApp() = app
}