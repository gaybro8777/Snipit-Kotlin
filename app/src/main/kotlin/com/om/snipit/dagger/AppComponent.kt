package com.om.snipit.dagger

import com.om.snipit.SnipitApp
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
  fun inject(app: SnipitApp)
  fun plus(homeModule: HomeModule): HomeComponent
}