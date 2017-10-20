package com.om.snipit.landing

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class IntroFragment : Fragment() {
  private var layoutResId: Int = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (!arguments.containsKey(LAYOUT_RES_ID)) {
      throw RuntimeException("Fragment must contain a layoutResId argument!")
    }

    layoutResId = arguments.getInt(LAYOUT_RES_ID)
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? =
      activity.layoutInflater.inflate(layoutResId, container, false)

  companion object {

    private val LAYOUT_RES_ID = "layoutResId"

    fun newInstance(layoutResId: Int): IntroFragment {
      val frag = IntroFragment()

      val b = Bundle()
      b.putInt(LAYOUT_RES_ID, layoutResId)
      frag.arguments = b

      return frag
    }
  }
}