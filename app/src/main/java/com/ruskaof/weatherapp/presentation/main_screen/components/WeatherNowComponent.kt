package com.ruskaof.weatherapp.presentation.main_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            .padding(top = 40.dp)
            .weight(3f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = nowForecastState.nowForecast.location,
            style = AppTheme.typography.primaryTextStyle
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
