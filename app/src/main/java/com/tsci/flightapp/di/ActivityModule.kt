package com.tsci.flightapp.di

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.tsci.weatherapp.presentation.navigation.ScreensNavigator
import com.tsci.weatherapp.presentation.navigation.ScreensNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class ActivityModule {

    @ActivityScoped
    @Binds
    abstract fun screensNavigator(screensNavigatorImpl: ScreensNavigatorImpl): ScreensNavigator

    companion object{
        @Provides
        fun appCompatActivity(activity: Activity): AppCompatActivity = activity as AppCompatActivity
    }
}