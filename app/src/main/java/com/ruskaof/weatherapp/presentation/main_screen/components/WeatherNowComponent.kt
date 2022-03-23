package com.ruskaof.weatherapp.presentation.main_screen.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ruskaof.weatherapp.common.Constants
import com.ruskaof.weatherapp.domain.model.NowForecast

@Composable
fun WeatherNow(nowForecast: NowForecast = Constants.NOW_FORECAST_EXAMPLE) {
    Text(nowForecast.toString())
}

@Preview
@Composable
fun WeatherNowPreview() {
    WeatherNow()
}