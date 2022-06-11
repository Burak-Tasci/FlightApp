package com.tsci.flightapp.presentation.ui.splash

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tsci.flightapp.R
import com.tsci.flightapp.presentation.ui.login.LoginActivity.Companion.LOGGED
import com.tsci.weatherapp.presentation.navigation.ScreensNavigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    val activityScope = CoroutineScope(Dispatchers.Main)

    @Inject lateinit var screensNavigator: ScreensNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        activityScope.launch {

            val sharedPref = baseContext.getSharedPreferences(
                LOGGED, Context.MODE_PRIVATE
            )
            if (sharedPref.getBoolean(LOGGED, false)){
                screensNavigator.apply {
                    toLoginActivity()           // TODO: Login'e de yönleniyor yine, backstack'te login sayfası olur
                    toHomeActivity()
                    finish()
                }
            }else{
                screensNavigator.toLoginActivity()
                finish()
            }

        }
    }

    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }
}