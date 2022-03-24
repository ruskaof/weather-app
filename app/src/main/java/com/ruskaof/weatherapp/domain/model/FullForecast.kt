package com.ruskaof.weatherapp.domain.model


import com.ruskaof.weatherapp.data.dto.FullForecastDto

data class FullForecast(
    val forecast: List<Forecast>
)

fun FullForecastDto.toFullForecast(): FullForecast {
    return FullForecast(forecast = forecastDto.map {
        it.toForecast()
    })
}