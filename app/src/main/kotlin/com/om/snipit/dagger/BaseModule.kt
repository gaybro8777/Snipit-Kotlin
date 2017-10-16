package com.om.snipit.dagger

import android.content.Context
import com.om.snipit.BaseActivity
import com.om.snipit.PREFS
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseModule(val activity: BaseActivity) {
  @Provides
  @Singleton
  fun providesSharedPrefs() = activity.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
}
