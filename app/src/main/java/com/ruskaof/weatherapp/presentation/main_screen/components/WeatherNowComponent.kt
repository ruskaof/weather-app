package com.ruskaof.weatherapp.presentation.main_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ruskaof.weatherapp.domain.model.NowForecast
import com.ruskaof.weatherapp.presentation.main_screen.NowForecastState
import com.ruskaof.weatherapp.presentation.theme.AppTheme
import kotlin.math.roundToInt

@Composable
fun ColumnScope.WeatherNowComponent(
    nowForecastState: NowForecastState,
    buttonOnClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .weight(1f)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Button(
                onClick = buttonOnClick,
                modifier = Modifier.size(25.dp)
            ) {}
        }


        NowForecastShower(nowForecast = nowForecastState.nowForecast)
    }
}

@Composable
fun NowForecastShower(
    nowForecast: NowForecast
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = nowForecast.location, style = AppTheme.typography.primaryTextStyle)
        Text(text = nowForecast.condition, style = AppTheme.typography.smallerTextStyle)
        Text(
            text = nowForecast.tempC.roundToInt().toString() + "°C",
            style = AppTheme.typography.biggerTextStyle
        )
    }
}