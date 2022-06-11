package com.tsci.flightapp.data.network.service

import com.tsci.flightapp.data.network.common.Result
import com.tsci.flightapp.data.network.dto.FlightsDto
import javax.inject.Inject

class FlightAppService @Inject constructor(
    private val apiService: ApiService
) : BaseService() {

    suspend fun getFlights(): Result<FlightsDto> {
        return createCall { apiService.getFlights() }
    }
}