package com.tsci.flightapp.domain.mapper

import com.tsci.flightapp.data.network.dto.DepartureDto
import com.tsci.flightapp.domain.models.DepartureDomainModel

object DepartureDtoMapper {

    fun map(departureDto: DepartureDto?): DepartureDomainModel?{

        if (departureDto == null)
            return null

        return DepartureDomainModel(
            airport = departureDto.airport,
            iata = departureDto.iata,
            estimated = departureDto.estimated,
            delay = departureDto.delay.toString(),
            terminal = departureDto.terminal ?: ""
        )

    }
}