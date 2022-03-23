package com.ruskaof.weatherapp.presentation.main_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private val _textState = mutableStateOf("lll")
    val textState: State<String> = _textState

    init {
        getWeather("Moscow")
    }

    fun getWeather(location: String) {
        weatherUseCase.invokeGetNowForecast(location = location).onEach {
            when (it) {
                is Resource.Success -> {
                    _textState.value = it.data.toString()
                }
                is Resource.Error -> {
                    _textState.value = it.message ?: "???"
                }
                is Resource.Loading -> {
                    _textState.value = "loading"
                }
            }
        }.launchIn(viewModelScope)
    }
}
