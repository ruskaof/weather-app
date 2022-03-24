package com.ruskaof.weatherapp.data.dto


import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("avg_temp_c")
    val avgTempC: Double,
    @SerializedName("avg_temp_f")
    val avgTempF: Double,
    @SerializedName("chance_of_rain")
    val chanceOfRain: Int,
    @SerializedName("condition")
    val condition: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("icon_url")
    val iconUrl: String,
    @SerializedName("max_temp_c")
    val maxTempC: Double,
    @SerializedName("max_temp_f")
    val maxTempF: Double,
    @SerializedName("max_wind_kph")
    val maxWindKph: Double,
    @SerializedName("max_wind_mph")
    val maxWindMph: Double,
    @SerializedName("min_temp_c")
    val minTempC: Double,
    @SerializedName("min_temp_f")
    val minTempF: Double,
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunset")
    val sunset: String,
    @SerializedName("will_it_rain")
    val willItRain: Boolean
)