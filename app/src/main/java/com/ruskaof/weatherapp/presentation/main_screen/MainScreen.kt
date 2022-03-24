package com.ruskaof.weatherapp.presentation.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ruskaof.weatherapp.presentation.main_screen.components.WeatherFullComponent
import com.ruskaof.weatherapp.presentation.main_screen.components.WeatherNowComponent
import com.ruskaof.weatherapp.presentation.theme.AppTheme

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.primaryBackground)
    ) {
        if (viewModel.weatherFullState.value.isLoading || viewModel.weatherNowState.value.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(100.dp)
                )
            }
        } else {
            WeatherNowComponent(viewModel.weatherNowState.value) {
                viewModel.getCurrentWeather("Saint Petersburg")
            }
            WeatherFullComponent(viewModel.weatherFullState.value.fullForecast) {
                viewModel.getFullForecast(7, "Saint Petersburg")
            }
        }
    }
}