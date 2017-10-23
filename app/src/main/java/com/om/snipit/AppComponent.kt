package com.om.snipit

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
  fun inject(app: SnipitApp)

  fun addComponent(mainModule: BaseModule): BaseComponent
}