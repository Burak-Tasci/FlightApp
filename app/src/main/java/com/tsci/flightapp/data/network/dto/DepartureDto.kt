package com.tsci.flightapp.data.network.dto

data class DepartureDto(
    val actual: Any?,
    val actual_runway: Any?,
    val airport: String,
    val delay: Any?,
    val estimated: String,
    val estimated_runway: Any?,
    val gate: String?,
    val iata: String,
    val icao: String,
    val scheduled: String,
    val terminal: String?,
    val timezone: String
)