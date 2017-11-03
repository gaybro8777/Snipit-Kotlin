package com.om.snipit.dagger

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.om.snipit.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseModule(private val context: Context) {
  @Provides
  @Singleton
  fun provideSharedPreferences(): SharedPreferences = context.getSharedPreferences("PREFS",
      Context.MODE_PRIVATE)

  @Provides
  @Singleton
  fun providesDBHelper(): AppDatabase = Room.databaseBuilder(context,
      AppDatabase::class.java, "snipit_db").build()
}