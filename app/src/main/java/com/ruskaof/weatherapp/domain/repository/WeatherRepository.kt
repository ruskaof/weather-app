package com.ruskaof.weatherapp.domain.repository

import com.ruskaof.weatherapp.data.dto.NowForecastDto
import com.ruskaof.weatherapp.data.dto.NowForecastPostDto

interface WeatherRepository {
    suspend fun getForecastNow(location : String): NowForecastDto
}