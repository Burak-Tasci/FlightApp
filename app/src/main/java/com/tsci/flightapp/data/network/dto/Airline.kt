package com.tsci.flightapp.data.network.dto

data class Airline(             // TODO: Servisten gelecek olan şeyler her zaman nullable olsun
    val iata: String,
    val icao: String,
    val name: String
)