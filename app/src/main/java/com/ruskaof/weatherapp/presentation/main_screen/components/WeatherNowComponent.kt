package com.ruskaof.weatherapp.presentation.main_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ruskaof.weatherapp.presentation.main_screen.NowForecastState
import com.ruskaof.weatherapp.presentation.theme.AppTheme
import kotlin.math.roundToInt

@Composable
fun ColumnScope.WeatherNowComponent(
    nowForecastState: NowForecastState,
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
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, bottom = 5.dp)
        ) {
            Image(
                painter = painterResource(com.ruskaof.weatherapp.R.drawable.ic_outline_cloud_24),
                modifier = Modifier.size(20.dp),
                colorFilter = ColorFilter.tint(AppTheme.typography.locationTextStyle.color),
                contentDescription = "Cloud icon"
            )
            Text(text = " " + nowForecastState.nowForecast.cloud.toString() + "%")
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, bottom = 5.dp)
        ) {
            Image(
                painter = painterResource(com.ruskaof.weatherapp.R.drawable.ic_baseline_air_24),
                modifier = Modifier.size(20.dp),
                colorFilter = ColorFilter.tint(AppTheme.typography.locationTextStyle.color),
                contentDescription = "Wind icon"
            )
            Text(
                text = " " + nowForecastState.nowForecast.windKph.roundToInt().toString() + " km/h"
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, bottom = 5.dp)
        ) {
            Image(
                painter = painterResource(com.ruskaof.weatherapp.R.drawable.ic_free_icon_font_raindrops_5527924),
                modifier = Modifier.size(20.dp),
                colorFilter = ColorFilter.tint(AppTheme.typography.locationTextStyle.color),
                contentDescription = "Drops icon"
            )
            Text(
                text = " " + nowForecastState.nowForecast.humidity + " %"
            )
        }

    }
}
