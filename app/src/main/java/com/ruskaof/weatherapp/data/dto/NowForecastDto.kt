package com.ruskaof.weatherapp.data.dto


import com.google.gson.annotations.SerializedName

data class NowForecastDto(
    @SerializedName("cloud")
    val cloud: Int,
    @SerializedName("condition")
    val condition: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("daytime")
    val daytime: Boolean,
    @SerializedName("feels_like_c")
    val feelsLikeC: Double,
    @SerializedName("feels_like_f")
    val feelsLikeF: Double,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("icon_url")
    val iconUrl: String,
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
    @SerializedName("temp_c")
    val tempC: Double,
    @SerializedName("temp_f")
    val tempF: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("wind_degree")
    val windDegree: Int,
    @SerializedName("wind_direction")
    val windDirection: String,
    @SerializedName("wind_kph")
    val windKph: Double,
    @SerializedName("wind_mph")
    val windMph: Double
)