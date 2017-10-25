package com.om.snipit.dagger

import android.content.Context
import com.om.snipit.database.DBHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseModule(val context: Context) {
  @Provides
  @Singleton
  fun provideSharedPrefs() = context.getSharedPreferences("PREFS", Context.MODE_PRIVATE)

  @Provides
  @Singleton
  fun providesDBHelper() = DBHelper(context)
}