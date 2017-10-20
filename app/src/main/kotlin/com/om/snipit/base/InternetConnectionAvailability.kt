package com.om.snipit.base

import android.content.Context
import android.net.ConnectivityManager

fun isInternetAvailable(context: Context): Boolean {
  val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

  return cm.activeNetworkInfo != null && cm.activeNetworkInfo.isConnectedOrConnecting
}