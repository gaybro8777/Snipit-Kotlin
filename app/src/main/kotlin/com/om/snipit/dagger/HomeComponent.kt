package com.om.snipit.dagger

import com.om.snipit.LauncherActivity
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(HomeModule::class))
interface HomeComponent {
  fun inject(activity: LauncherActivity)
}