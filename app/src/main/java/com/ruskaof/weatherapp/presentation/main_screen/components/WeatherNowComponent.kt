package com.ruskaof.weatherapp.presentation.main_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ruskaof.weatherapp.presentation.main_screen.NowForecastState
import com.ruskaof.weatherapp.presentation.theme.AppTheme
import kotlin.math.roundToInt

@Composable
fun ColumnScope.WeatherNowComponent(
    nowForecastState: NowForecastState,
    buttonOnClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .weight(3f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = nowForecastState.nowForecast.location,
            style = AppTheme.typography.locationTextStyle
        )
        Text(
            text = nowForecastState.nowForecast.condition,
            style = AppTheme.typography.nowWeatherConditionStyle
        )
        Text(
            text = nowForecastState.nowForecast.tempC.roundToInt().toString() + "°C",
            style = AppTheme.typography.mainTemperatureDegreeStyle
        )
    }
}
