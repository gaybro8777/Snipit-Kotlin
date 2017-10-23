package com.om.snipit

import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(BaseModule::class))

interface BaseComponent {
  fun inject(activity: BaseActivity)
}