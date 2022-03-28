package com.ruskaof.weatherapp.common

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.ruskaof.weatherapp.domain.model.Forecast
import com.ruskaof.weatherapp.domain.model.FullForecast
import com.ruskaof.weatherapp.domain.model.NowForecast
import java.time.LocalDate

object Constants {
    const val BASE_URL = "https://api.m3o.com"
    const val M3O_API_TOKEN = "your token"
    val locationState: State<String> = mutableStateOf("Saint Petersburg")
    val NOW_FORECAST_EXAMPLE = NowForecast(
        location = "London",
        region = "City of London, Greater London",
        country = "City of London, Greater London",
        latitude = 51.52,
        longitude = -0.11,
        timezone = "Europe/London",
        localTime = "2021-06-23 11:18",
        tempC = 16.0,
        tempF = 60.8,
        feelsLikeC = 16.0,
        feelsLikeF = 60.8,
        humidity = 48,
        cloud = 75,
        daytime = true,
        condition = "Partly cloudy",
        iconUrl = "//cdn.weatherapi.com/weather/64x64/day/116.png",
        windMph = 4.3,
        windKph = 6.8,
        windDirection = "NE",
        windDegree = 40
    )
    val FULL_FORECAST_EXAMPLE = FullForecast(
        listOf(
            Forecast(
                0.0,
                0.0,
                0,
                "ERROR",
                LocalDate.MIN,
                "ERROR",
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                "ERROR",
                "ERROR",
                false
            )
        )
    )
}