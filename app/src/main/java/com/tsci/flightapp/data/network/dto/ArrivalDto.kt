package com.tsci.flightapp.data.network.dto

data class ArrivalDto(
    val `actual`: Any?,
    val actual_runway: Any?,
    val airport: String?,
    val baggage: Any?,
    val delay: Any?,
    val estimated: String?,
    val estimated_runway: Any?,
    val gate: Any?,
    val iata: String?,
    val icao: String?,
    val scheduled: String?,
    val terminal: Any?,
    val timezone: String?
)