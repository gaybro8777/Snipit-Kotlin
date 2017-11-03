package com.om.snipit.dagger

import com.om.snipit.base.SnipitApp
import dagger.Component

@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

  fun inject(app: SnipitApp)

  fun plus(baseModule: BaseModule): BaseComponent
}