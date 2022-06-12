package com.tsci.flightapp.domain.mapper

import com.tsci.flightapp.data.network.dto.DepartureDto
import com.tsci.flightapp.domain.models.DepartureDomainModel

object DepartureDtoMapper {

    fun map(departureDto: DepartureDto?): DepartureDomainModel?{

        if (departureDto == null)
            return null

        return DepartureDomainModel(
            airport = departureDto.airport ?: "Unknown",
            iata = departureDto.iata ?: "Unknown",
            estimated = departureDto.estimated ?: "Unknown",
            delay = departureDto.delay.toString(),
            terminal = departureDto.terminal ?: "Unknown"
        )

    }
}