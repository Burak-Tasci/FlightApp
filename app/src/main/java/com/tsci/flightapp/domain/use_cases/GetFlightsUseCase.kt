package com.tsci.flightapp.domain.use_cases

import com.tsci.flightapp.data.network.common.Result
import com.tsci.flightapp.data.network.repository.FlightsRepository
import com.tsci.flightapp.domain.mapper.FlightDtoMapper
import com.tsci.flightapp.domain.models.FlightDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFlightsUseCase @Inject constructor(
    private val flightsRepository: FlightsRepository
) {

    operator fun invoke(): Flow<Result<List<FlightDomainModel?>>> = flow {


        try {
            val flights = flightsRepository.getFlights().data?.map { FlightDtoMapper.map(it) }
            emit(Result.Success(flights ?: emptyList()))
        } catch (e: HttpException) {
            emit(Result.Error(e.localizedMessage ?: "An unexpected error occured!"))
        } catch (e: IOException) {
            emit(Result.Error("Could not reach server, check your internet connection."))
        }
    }
}