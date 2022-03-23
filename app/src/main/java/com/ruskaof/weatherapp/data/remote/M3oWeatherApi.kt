package com.ruskaof.weatherapp.data.remote

import com.ruskaof.weatherapp.common.Constants
import com.ruskaof.weatherapp.data.dto.FullForecastDto
import com.ruskaof.weatherapp.data.dto.FullPostDto
import com.ruskaof.weatherapp.data.dto.NowForecastDto
import com.ruskaof.weatherapp.data.dto.NowForecastPostDto
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface M3oWeatherApi {
    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer ${Constants.M3O_API_TOKEN}"
    )
    @POST("/v1/weather/Now")
    suspend fun getNowForecast(
        @Body nowForecastPostDto: NowForecastPostDto
    ): NowForecastDto
}