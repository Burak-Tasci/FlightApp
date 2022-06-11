package com.tsci.flightapp.domain.models

data class DepartureDomainModel(
    val airport: String,
    val iata: String,
    val delay: String,
    val estimated: String,
    val terminal: String
)