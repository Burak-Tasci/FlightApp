package com.tsci.flightapp.di

import com.tsci.flightapp.data.network.Routes.BASE_URL
import com.tsci.flightapp.data.network.repository.FlightsRepository
import com.tsci.flightapp.data.network.service.ApiService
import com.tsci.flightapp.data.network.service.FlightAppService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideFlightApi(): ApiService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())         // TODO: OkHttpClient kur mutlaka, Logcat'de servis isteklerini takip edebilirsin böylece
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideFlightRepository(flightAppService: FlightAppService): FlightsRepository = FlightsRepository(flightAppService = flightAppService)
}