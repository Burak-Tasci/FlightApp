package com.tsci.flightapp.presentation.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tsci.flightapp.data.network.common.Result
import com.tsci.flightapp.domain.use_cases.GetFlightsUseCase
import com.tsci.flightapp.presentation.ui.FlightsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getFlightsUseCase: GetFlightsUseCase
): ViewModel() {

    private val _state = MutableLiveData<FlightsState>()
    val state: LiveData<FlightsState> = _state

    init {
        getFlights()            // TODO: Bunun çağırılmasını activity içerisinde yap
    }

    private fun getFlights() {

        getFlightsUseCase().onEach { result ->
            when(result){
                is Result.Success -> {
                    Log.d("filan", "getFlights: ${result.data}")
                    _state.value = FlightsState(flights = (result.data))
                }
                is Result.Error -> {
                    Log.d("filan", "getFlights: ${result.error}")
                    _state.value = FlightsState(                            // TODO: Bu senin aslında error state'in, farklı bir state'de tutman gerekiyor
                        error = result.error
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}