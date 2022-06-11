package com.tsci.flightapp.presentation.ui

import com.tsci.flightapp.domain.models.FlightDomainModel

data class FlightsState (
    val flights: List<FlightDomainModel?> = emptyList(),
    val error: String = ""
)