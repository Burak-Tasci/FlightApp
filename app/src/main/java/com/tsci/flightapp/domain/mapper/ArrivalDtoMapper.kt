package com.tsci.flightapp.domain.mapper

import com.tsci.flightapp.data.network.dto.ArrivalDto
import com.tsci.flightapp.domain.models.ArrivalDomainModel

object ArrivalDtoMapper {

    fun map(arrivalDto: ArrivalDto?): ArrivalDomainModel?{

        if (arrivalDto == null)
            return null

        return ArrivalDomainModel(
            airport = arrivalDto.airport,
            delay = arrivalDto.delay.toString(),
            estimated = arrivalDto.estimated,
            iata = arrivalDto.iata,
            terminal = arrivalDto.terminal.toString()
        )
    }
}