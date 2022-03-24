package com.ruskaof.weatherapp.presentation.main_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ruskaof.weatherapp.domain.model.Forecast
import com.ruskaof.weatherapp.presentation.theme.AppTheme
import java.util.*
import kotlin.math.roundToInt

@Composable
fun FullForecastItem(
    forecast: Forecast
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {
            Text(
                text = forecast.date.dayOfWeek.toString()
                    .lowercase()
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                style = AppTheme.typography.primaryTextStyle
            )
            Text(
                text = forecast.maxTempC.roundToInt().toString() + "°C",
                style = AppTheme.typography.primaryTextStyle
            )
        }
        Text(
            text = forecast.condition,
            style = AppTheme.typography.smallerTextStyle
        )
    }
}