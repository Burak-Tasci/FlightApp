package com.tsci.weatherapp.presentation.navigation

interface ScreensNavigator {

    fun navigateBack()
    fun toLoginActivity()
    fun toHomeActivity()
    fun toDetailsActivity()
}