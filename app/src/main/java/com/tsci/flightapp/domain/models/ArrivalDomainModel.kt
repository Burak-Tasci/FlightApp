package com.tsci.flightapp.domain.models

data class ArrivalDomainModel(
    val airport: String,
    val iata: String,
    val delay: Any,
    val estimated: String,
    val terminal: String

)