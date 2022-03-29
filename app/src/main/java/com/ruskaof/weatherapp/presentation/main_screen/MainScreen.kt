package com.ruskaof.weatherapp.presentation.main_screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ruskaof.weatherapp.R
import com.ruskaof.weatherapp.common.Constants
import com.ruskaof.weatherapp.presentation.main_screen.components.ChangeLocationDialog
import com.ruskaof.weatherapp.presentation.main_screen.components.WeatherFullComponent
import com.ruskaof.weatherapp.presentation.main_screen.components.WeatherNowComponent
import com.ruskaof.weatherapp.presentation.theme.AppTheme

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val circle1Size by animateDpAsState(
        targetValue = viewModel.circle1SizeState.value,
        animationSpec = tween(1000)
    )
    val circle2Size by animateDpAsState(
        targetValue = viewModel.circle2SizeState.value,
        animationSpec = tween(1000)
    )
    val circleColor1 = AppTheme.colors.circleColor1
    val circleColor2 = AppTheme.colors.circleColor2

    val alpha by animateFloatAsState(
        targetValue = viewModel.alphaState.value,
        animationSpec = tween(1000)
    )

    if (viewModel.changeWeatherIsDialogOpen.value) {
        ChangeLocationDialog(viewModel = viewModel)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.primaryBackground)
            .drawBehind {
                drawCircle(
                    color = circleColor1,
                    center = Offset.Zero,
                    radius = circle1Size.toPx()
                )
                drawCircle(
                    color = circleColor2,
                    center = Offset(size.width, size.height),
                    radius = circle2Size.toPx()
                )
            }
    ) {
        if (viewModel.weatherNowState.value.isError || viewModel.weatherFullState.value.isError) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Could not connect to the server.\nPlease check your internet connection",
                    style = AppTheme.typography.locationTextStyle.plus(TextStyle(textAlign = TextAlign.Center))
                )
            }
        }
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
            viewModel.setAlphaState(0.8f)
            viewModel.setCirclesSizes(500.dp, 300.dp)
            WeatherNowComponent(viewModel.weatherNowState.value)
            WeatherFullComponent(viewModel.weatherFullState.value.fullForecast)
        }
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .size(40.dp),
        contentAlignment = Alignment.TopEnd
    ) {

        Image(
            painter = painterResource(R.drawable.ic_round_refresh_24),
            modifier = Modifier
                .size(50.dp)
                .clickable {
                    viewModel.getCurrentWeather(Constants.locationState.value)
                    viewModel.getFullForecast(4, Constants.locationState.value)
                },
            colorFilter = ColorFilter.tint(AppTheme.typography.locationTextStyle.color.copy(alpha = alpha)),
            contentDescription = "Refresh icon"
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .size(40.dp),
        contentAlignment = Alignment.TopStart
    ) {

        Image(
            painter = painterResource(R.drawable.ic_baseline_location_city_24),
            modifier = Modifier
                .size(50.dp)
                .clickable {
                    viewModel.openDialog()
                },
            colorFilter = ColorFilter.tint(AppTheme.typography.locationTextStyle.color.copy(alpha = alpha)),
            contentDescription = "Refresh icon"
        )
    }
}