package com.om.snipit.landing

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.GoogleApiClient
import com.om.snipit.R
import com.om.snipit.base.*
import com.om.snipit.books.BooksActivity
import com.om.snipit.landing.classes.DefaultIndicatorController
import com.om.snipit.models.User
import kotlinx.android.synthetic.main.activity_login.*
import timber.log.Timber

class LoginActivity : BaseActivity(), GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

  private val RC_SIGN_IN = 0

  val gso = GoogleSignInOptions.Builder(
      GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()

  private lateinit var googleApiClient : GoogleApiClient

  val indicatorController = DefaultIndicatorController()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

    googleApiClient = GoogleApiClient.Builder(this).enableAutoManage(this, this)
        .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
        .build()

    viewPager.adapter = IntroAdapter(supportFragmentManager)

    signInGoogleBTN.setSize(SignInButton.SIZE_WIDE)
    signInGoogleBTN.setColorScheme(SignInButton.COLOR_DARK)

    signInGoogleBTN.setOnClickListener { signInGoogle() }

    viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
      override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

      }

      override fun onPageSelected(position: Int) {
        indicatorController.selectPosition(position)
      }

      override fun onPageScrollStateChanged(state: Int) {

      }
    })

    initController()
  }

  public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
    super.onActivityResult(requestCode, resultCode, data)

    if (requestCode == RC_SIGN_IN) {
      val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
      handleSignInResult(result)
    }
  }

  private fun handleSignInResult(result: GoogleSignInResult) {
    if (result.isSuccess) {
      Timber.d("Success!")
      if (isInternetAvailable(this)) {
        val loggingInDialog = ProgressDialog.show(this@LoginActivity, "",
            resources.getString(R.string.logging_in_dialog_message), true)

        val acct = result.signInAccount

        val user = User()

        Timber.d("We are here")

        user.full_name = acct?.displayName.toString()
        user.email_address = acct?.email.toString()
        user.photo_url = acct?.photoUrl.toString()

        val prefsEditor = prefs.edit()
        prefsEditor.putBoolean(USER_LOGGED_IN, true)
        prefsEditor.putString(USER_FULL_NAME, user.full_name)
        prefsEditor.putString(USER_DISPLAY_PHOTO, user.photo_url)
        prefsEditor.putString(USER_EMAIL, user.email_address)
        prefsEditor.apply()

        val openBooksActivity = Intent(this@LoginActivity, BooksActivity::class.java)
        startActivity(openBooksActivity)

        finish()
      } else {
        AlertDialog.Builder(this@LoginActivity).setMessage(
            R.string.no_internet_connection)
            .setPositiveButton(R.string.OK, { dialog, _ -> dialog.dismiss() })
            .show()
      }
    } else {
      // Signed out, show unauthenticated UI.
    }
  }

  private fun initController() {
    indicator_container.addView(indicatorController.newInstance(this))

    indicatorController.initialize(4)
  }

  private fun signInGoogle() {
    val signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient)
    startActivityForResult(signInIntent, RC_SIGN_IN)
  }

  inner class IntroAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? = when (position) {
      0 -> IntroFragment.newInstance(
          R.layout.fragment_intro_slide_1)
      1 -> IntroFragment.newInstance(
          R.layout.fragment_intro_slide_2)
      2 -> IntroFragment.newInstance(
          R.layout.fragment_intro_slide_3)
      3 -> IntroFragment.newInstance(
          R.layout.fragment_intro_slide_4)
      else -> null
    }

    override fun getCount(): Int = 4
  }

  override fun onConnectionFailed(p0: ConnectionResult) {
  }

  override fun onConnected(p0: Bundle?) {
  }

  override fun onConnectionSuspended(p0: Int) {
  }
}