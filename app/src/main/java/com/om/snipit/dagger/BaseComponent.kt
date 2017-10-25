package com.om.snipit.dagger

import com.om.snipit.base.BaseActivity
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(BaseModule::class))

interface BaseComponent {
  fun inject(activity: BaseActivity)
}