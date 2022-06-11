package com.tsci.flightapp.data.network.dto

data class FlightDto(
    val aircraft: Any?,
    val airline: Airline,
    val arrival: ArrivalDto,
    val departure: DepartureDto,
    val flight: Flight,
    val flight_date: String,
    val flight_status: String,
    val live: Any?
)