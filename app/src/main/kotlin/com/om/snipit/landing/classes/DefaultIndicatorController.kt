package com.om.snipit.landing.classes

import android.content.Context
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.om.snipit.R


class DefaultIndicatorController : IndicatorController {
  private var selectedDotColor = DEFAULT_COLOR
  private var unselectedDotColor = DEFAULT_COLOR
  private var mCurrentposition: Int = 0
  private var mContext: Context? = null
  private lateinit var mDotLayout: LinearLayout
  private var mDots: MutableList<ImageView>? = null
  private var mSlideCount: Int = 0

  override fun newInstance(context: Context): View {
    mContext = context
    mDotLayout = View.inflate(context, R.layout.app_intro_progress_indicator, null) as LinearLayout
    return mDotLayout
  }

  override fun initialize(slideCount: Int) {
    mDots = ArrayList()
    mSlideCount = slideCount
    selectedDotColor = -1
    unselectedDotColor = -1

    for (i in 0 until slideCount) {
      val dot = ImageView(mContext)
      dot.setImageDrawable(ContextCompat.getDrawable(mContext!!,
          R.drawable.indicator_dot_grey))

      val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
          LinearLayout.LayoutParams.WRAP_CONTENT)

      mDotLayout.addView(dot, params)
      mDots!!.add(dot)
    }

    selectPosition(
        FIRST_PAGE_NUM)
  }

  override fun selectPosition(index: Int) {
    mCurrentposition = index
    for (i in 0 until mSlideCount) {
      val drawableId = if (i == index) R.drawable.indicator_dot_white else R.drawable.indicator_dot_grey
      val drawable = ContextCompat.getDrawable(mContext!!, drawableId)
      if (selectedDotColor != DEFAULT_COLOR && i == index) {
        drawable.mutate().setColorFilter(selectedDotColor, PorterDuff.Mode.SRC_IN)
      }
      if (unselectedDotColor != DEFAULT_COLOR && i != index) {
        drawable.mutate().setColorFilter(unselectedDotColor, PorterDuff.Mode.SRC_IN)
      }
      mDots!![i].setImageDrawable(drawable)
    }
  }

  override fun setSelectedIndicatorColor(color: Int) {
    selectedDotColor = color
    selectPosition(mCurrentposition)
  }

  override fun setUnselectedIndicatorColor(color: Int) {
    unselectedDotColor = color
    selectPosition(mCurrentposition)
  }

  companion object {
    val DEFAULT_COLOR = 1
    private val FIRST_PAGE_NUM = 0
  }
}