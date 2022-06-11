package com.tsci.flightapp.domain.models

import com.tsci.flightapp.data.network.common.FlightStatus

data class FlightDomainModel(
    val airline: String?,
    val flightStatus: FlightStatus?,
    val flightIata: String?,
    val departure: DepartureDomainModel?,
    val arrival: ArrivalDomainModel?
)