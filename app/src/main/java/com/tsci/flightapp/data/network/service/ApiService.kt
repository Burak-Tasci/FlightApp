package com.tsci.flightapp.data.network.service

import com.tsci.flightapp.data.network.Routes
import com.tsci.flightapp.data.network.dto.FlightsDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Routes.FLIGHTS)
    suspend fun getFlights(): Response<FlightsDto>
}