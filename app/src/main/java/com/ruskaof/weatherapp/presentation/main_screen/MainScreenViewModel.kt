package com.ruskaof.weatherapp.presentation.main_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruskaof.weatherapp.common.Constants
import com.ruskaof.weatherapp.common.Resource
import com.ruskaof.weatherapp.domain.use_case.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase
) : ViewModel() {
    private val _weatherNowState =
        mutableStateOf(NowForecastState(Constants.NOW_FORECAST_EXAMPLE, false))
    val weatherNowState: State<NowForecastState> = _weatherNowState

    private val _weatherFullState =
        mutableStateOf(FullForecastState(Constants.FULL_FORECAST_EXAMPLE, false))
    val weatherFullState: State<FullForecastState> = _weatherFullState

    init {
        getCurrentWeather("Saint Petersburg")
        getFullForecast(4, "Saint Petersburg")
    }

    fun getCurrentWeather(location: String) {
        weatherUseCase.invokeGetNowForecast(location = location).onEach {
            when (it) {
                is Resource.Success -> {
                    _weatherNowState.value =
                        NowForecastState(it.data ?: Constants.NOW_FORECAST_EXAMPLE, false)
                }
                is Resource.Error -> {
                    _weatherNowState.value =
                        NowForecastState(
                            Constants.NOW_FORECAST_EXAMPLE,
                            isLoading = false,
                            isError = true
                        )
                }
                is Resource.Loading -> {
                    _weatherNowState.value =
                        NowForecastState(Constants.NOW_FORECAST_EXAMPLE, true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getFullForecast(days: Int, location: String) {
        weatherUseCase.invokeGetFullForecast(days = days, location = location).onEach {
            when (it) {
                is Resource.Success -> {
                    _weatherFullState.value =
                        FullForecastState(it.data ?: Constants.FULL_FORECAST_EXAMPLE, false)
                }
                is Resource.Error -> {
                    _weatherFullState.value =
                        FullForecastState(Constants.FULL_FORECAST_EXAMPLE, false, isError = true)
                }
                is Resource.Loading -> {
                    _weatherFullState.value =
                        FullForecastState(Constants.FULL_FORECAST_EXAMPLE, true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
