package com.ruskaof.weatherapp.presentation.main_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ruskaof.weatherapp.domain.model.Forecast
import com.ruskaof.weatherapp.presentation.theme.AppTheme
import java.util.*
import kotlin.math.roundToInt

@Composable
fun FullForecastItem(
    forecast: Forecast
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = AppTheme.shapes.fullForecastCardShape,
        elevation = 5.dp,
        backgroundColor = AppTheme.colors.cardBackground
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Column(
                modifier = Modifier.weight(5f)
            ) {
                Text(
                    modifier = Modifier,
                    text = forecast.date.dayOfWeek.toString().substring(0..2).lowercase()
                        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } +
                            ", " + forecast.date.month.toString().substring(0..2).lowercase()
                        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } +
                            " " + forecast.date.dayOfMonth,
                    style = AppTheme.typography.inListDateStyle
                )
                Text(
                    modifier = Modifier,
                    text = forecast.condition,
                    style = AppTheme.typography.inListWeatherConditionStyle
                )
            }
            Text(
                modifier = Modifier.weight(2.4f),
                text = forecast.avgTempC.roundToInt().toString() + "°C",
                style = AppTheme.typography.inListTemperatureDegreeStyle,
                textAlign = TextAlign.Right
            )
        }
    }
}