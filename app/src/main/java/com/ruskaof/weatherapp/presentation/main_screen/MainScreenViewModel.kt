package com.ruskaof.weatherapp.presentation.main_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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
    private val _locationState: MutableState<String> = Constants.locationState as MutableState
    val locationState: State<String> = _locationState

    private val _changeWeatherIsDialogOpen = mutableStateOf(false)
    val changeWeatherIsDialogOpen: State<Boolean> = _changeWeatherIsDialogOpen

    private val _circle1SizeState = mutableStateOf(0.dp)
    var circle1SizeState: State<Dp> = _circle1SizeState

    private val _circle2SizeState = mutableStateOf(0.dp)
    var circle2SizeState: State<Dp> = _circle2SizeState

    private val _alphaState = mutableStateOf(0f)
    var alphaState: State<Float> = _alphaState

    private val _weatherNowState =
        mutableStateOf(NowForecastState(Constants.NOW_FORECAST_EXAMPLE, false))
    val weatherNowState: State<NowForecastState> = _weatherNowState

    private val _weatherFullState =
        mutableStateOf(FullForecastState(Constants.FULL_FORECAST_EXAMPLE, false))
    val weatherFullState: State<FullForecastState> = _weatherFullState

    init {
        getCurrentWeather(Constants.locationState.value)
        getFullForecast(4, Constants.locationState.value)
    }

    fun getCurrentWeather(location: String) {
        weatherUseCase.invokeGetNowForecast(location = location).onEach {
            when (it) {
                is Resource.Success -> {
                    _weatherNowState.value =
                        NowForecastState(it.data ?: Constants.NOW_FORECAST_EXAMPLE, false)
                }
                is Resource.Error -> {
                    _weatherNowState.value = _weatherNowState.value.copy(
                        isLoading = false,
                        isError = true
                    )
                }
                is Resource.Loading -> {
                    _weatherNowState.value = _weatherNowState.value.copy(
                        isLoading = true,
                        isError = false
                    )
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

    fun changeLocation(newLocation: String) {
        _locationState.value = newLocation
    }

    fun openDialog() {
        _changeWeatherIsDialogOpen.value = true
    }

    fun closeDialog() {
        _changeWeatherIsDialogOpen.value = false
    }

    fun setCirclesSizes(s1: Dp, s2: Dp) {
        _circle1SizeState.value = s1
        _circle2SizeState.value = s2
    }

    fun setAlphaState(x: Float) {
        _alphaState.value = x
    }
}
