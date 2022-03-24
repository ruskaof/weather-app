package com.ruskaof.weatherapp.presentation.main_screen

import com.ruskaof.weatherapp.domain.model.FullForecast

data class FullForecastState(
    val fullForecast: FullForecast,
    val isLoading: Boolean
)