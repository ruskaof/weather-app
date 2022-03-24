package com.ruskaof.weatherapp.domain.model

import com.ruskaof.weatherapp.data.dto.ForecastDto
import java.time.LocalDate

data class Forecast(
    val avgTempC: Double,
    val avgTempF: Double,
    val chanceOfRain: Int,
    val condition: String,
    val date: LocalDate,
    val iconUrl: String,
    val maxTempC: Double,
    val maxTempF: Double,
    val maxWindKph: Double,
    val maxWindMph: Double,
    val minTempC: Double,
    val minTempF: Double,
    val sunrise: String,
    val sunset: String,
    val willItRain: Boolean
)

fun ForecastDto.toForecast(): Forecast {
    return Forecast(
        avgTempC,
        avgTempF,
        chanceOfRain,
        condition,
        LocalDate.parse(date),
        iconUrl,
        maxTempC,
        maxTempF,
        maxWindKph,
        maxWindMph,
        minTempC,
        minTempF,
        sunrise,
        sunset,
        willItRain
    )
}