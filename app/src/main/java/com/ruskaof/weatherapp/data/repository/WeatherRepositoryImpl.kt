package com.ruskaof.weatherapp.data.repository

import com.ruskaof.weatherapp.data.dto.NowForecastDto
import com.ruskaof.weatherapp.data.dto.NowForecastPostDto
import com.ruskaof.weatherapp.data.remote.M3oWeatherApi
import com.ruskaof.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: M3oWeatherApi
) : WeatherRepository {
    override suspend fun getForecastNow(location : String): NowForecastDto {
        return api.getNowForecast(NowForecastPostDto(location = location))
    }

}