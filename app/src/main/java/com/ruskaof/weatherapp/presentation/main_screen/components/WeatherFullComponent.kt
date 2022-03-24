package com.ruskaof.weatherapp.presentation.main_screen.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ruskaof.weatherapp.domain.model.FullForecast
import com.ruskaof.weatherapp.presentation.theme.AppTheme

@Composable
fun ColumnScope.WeatherFullComponent(
    fullForecast: FullForecast,
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .weight(2f)
            .fillMaxWidth(),
        shape = AppTheme.shapes.defaultShape,
        elevation = 5.dp,
        backgroundColor = AppTheme.colors.secondaryBackground
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(fullForecast.forecast) { item ->
                FullForecastItem(forecast = item)
            }

        }
    }
}