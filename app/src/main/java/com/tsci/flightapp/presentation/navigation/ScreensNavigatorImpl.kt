package com.tsci.weatherapp.presentation.navigation

import androidx.appcompat.app.AppCompatActivity
import com.tsci.flightapp.presentation.ui.details.DetailsActivity
import com.tsci.flightapp.presentation.ui.home.HomeActivity
import com.tsci.flightapp.presentation.ui.login.LoginActivity
import javax.inject.Inject

class ScreensNavigatorImpl @Inject constructor(private val activity: AppCompatActivity) :
    ScreensNavigator {

    override fun navigateBack() {
        activity.onBackPressed()
    }

    override fun toLoginActivity() {
        LoginActivity.open(activity)
        activity.finish()
    }


    override fun toHomeActivity() {
        HomeActivity.open(activity)
    }

    override fun toDetailsActivity() {
        DetailsActivity.open(activity)
    }
}