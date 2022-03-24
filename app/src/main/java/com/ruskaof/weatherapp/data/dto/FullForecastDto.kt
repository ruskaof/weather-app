package com.ruskaof.weatherapp.data.dto


import com.google.gson.annotations.SerializedName

data class FullForecastDto(
    @SerializedName("country")
    val country: String,
    @SerializedName("forecast")
    val forecastDto: List<ForecastDto>,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("local_time")
    val localTime: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("region")
    val region: String,
    @SerializedName("timezone")
    val timezone: String
)