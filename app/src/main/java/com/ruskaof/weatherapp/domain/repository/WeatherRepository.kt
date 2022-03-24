package com.ruskaof.weatherapp.domain.repository

import com.ruskaof.weatherapp.data.dto.FullForecastDto
import com.ruskaof.weatherapp.data.dto.NowForecastDto

interface WeatherRepository {
    suspend fun getForecastNow(location: String): NowForecastDto
    suspend fun getFullForecast(days: Int, location: String): FullForecastDto
}