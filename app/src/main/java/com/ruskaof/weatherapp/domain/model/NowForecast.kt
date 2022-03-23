package com.ruskaof.weatherapp.domain.model

import com.google.gson.annotations.SerializedName
import com.ruskaof.weatherapp.data.dto.NowForecastDto

data class NowForecast(
    val cloud: Int,
    val condition: String,
    val country: String,
    val daytime: Boolean,
    val feelsLikeC: Double,
    val feelsLikeF: Double,
    val humidity: Int,
    val iconUrl: String,
    val latitude: Double,
    val localTime: String,
    val location: String,
    val longitude: Double,
    val region: String,
    val tempC: Int,
    val tempF: Double,
    val timezone: String,
    val windDegree: Int,
    val windDirection: String,
    val windKph: Double,
    val windMph: Double
)

fun NowForecastDto.toNowForecast() : NowForecast {
    return NowForecast(
        cloud = cloud,
        condition = condition,
        country = country,
        daytime = daytime,
        feelsLikeC = feelsLikeC,
        feelsLikeF = feelsLikeF,
        humidity = humidity,
        iconUrl = iconUrl,
        latitude = latitude,
        localTime = localTime,
        location = location,
        longitude = longitude,
        region = region,
        tempC = tempC,
        tempF = tempF,
        timezone = timezone,
        windDegree = windDegree,
        windDirection = windDirection,
        windKph = windKph,
        windMph = windMph
    )
}
