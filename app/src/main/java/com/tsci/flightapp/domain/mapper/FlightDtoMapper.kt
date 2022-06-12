package com.tsci.flightapp.domain.mapper

import com.tsci.flightapp.data.network.common.FlightStatus
import com.tsci.flightapp.data.network.dto.FlightDto
import com.tsci.flightapp.domain.models.FlightDomainModel

object FlightDtoMapper {


    fun map(flightDto: FlightDto?): FlightDomainModel? {

        if (flightDto == null)
            return null

        val status: FlightStatus = when(flightDto.flight_status){
            "active" -> FlightStatus.ACTIVE
            "cancelled" -> FlightStatus.CANCELLED
            "scheduled" -> FlightStatus.SCHEDULED
            else -> FlightStatus.CANCELLED
        }

        return FlightDomainModel(
            airline= flightDto.airline?.name,
            flightIata = flightDto.flight?.iata,
            flightStatus = status,
            arrival = ArrivalDtoMapper.map(flightDto.arrival),
            departure = DepartureDtoMapper.map(flightDto.departure)
        )
    }
}