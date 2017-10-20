package com.om.snipit.landing.classes

import android.content.Context
import android.view.View


interface IndicatorController {
  fun newInstance(context: Context): View

  fun initialize(slideCount: Int)

  fun selectPosition(index: Int)

  fun setSelectedIndicatorColor(color: Int)

  fun setUnselectedIndicatorColor(color: Int)
}
