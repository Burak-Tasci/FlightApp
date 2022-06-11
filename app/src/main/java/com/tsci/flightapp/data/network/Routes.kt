package com.tsci.flightapp.data.network

import com.tsci.flightapp.BuildConfig

object Routes {

    const val BASE_URL = "http://api.aviationstack.com/v1/"

    const val FLIGHTS = "flights?access_key=${BuildConfig.API_KEY}"         // TODO: Bunu ayrı olarak yazma, GET'in içinde statik olarak dursun. Okunması zorlaşıyor
}