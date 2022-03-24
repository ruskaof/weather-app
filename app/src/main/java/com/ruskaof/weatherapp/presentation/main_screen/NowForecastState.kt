package com.ruskaof.weatherapp.presentation.main_screen

import com.ruskaof.weatherapp.domain.model.NowForecast

data class NowForecastState(
    val nowForecast: NowForecast,
    val isLoading: Boolean = false
)