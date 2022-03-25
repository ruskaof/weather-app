package com.ruskaof.weatherapp.presentation.main_screen.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ruskaof.weatherapp.domain.model.FullForecast

@Composable
fun ColumnScope.WeatherFullComponent(
    fullForecast: FullForecast,
) {
    LazyColumn(
        modifier = Modifier.weight(3f)
    ) {
        items(fullForecast.forecast) {
            FullForecastItem(forecast = it)
        }
    }
}