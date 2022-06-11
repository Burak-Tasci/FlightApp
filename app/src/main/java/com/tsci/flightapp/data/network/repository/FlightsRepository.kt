package com.tsci.flightapp.data.network.repository

import com.tsci.flightapp.data.network.common.Result
import com.tsci.flightapp.data.network.dto.FlightsDto
import com.tsci.flightapp.data.network.service.FlightAppService


class FlightsRepository(private val flightAppService: FlightAppService) {

    suspend fun getFlights(): FlightsDto {
        return when (val result = flightAppService.getFlights()) {
            is Result.Success -> result.data
            is Result.Error -> FlightsDto(emptyList())
        }
    }
}