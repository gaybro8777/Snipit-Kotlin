package com.om.snipit

import android.os.Bundle
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient

class LoginActivity : BaseActivity(), GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

  }

  override fun onConnected(p0: Bundle?) {
    TODO(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onConnectionSuspended(p0: Int) {
    TODO(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onConnectionFailed(p0: ConnectionResult) {
    TODO(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}