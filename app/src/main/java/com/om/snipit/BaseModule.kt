package com.om.snipit

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseModule(val activity: BaseActivity) {
  @Provides
  @Singleton
  fun provideSharedPrefs() = activity.getSharedPreferences("PREFS", Context.MODE_PRIVATE)
}