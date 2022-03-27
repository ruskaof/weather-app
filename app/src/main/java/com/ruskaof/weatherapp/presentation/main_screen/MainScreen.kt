package com.ruskaof.weatherapp.presentation.main_screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
import com.ruskaof.weatherapp.presentation.main_screen.components.WeatherFullComponent
import com.ruskaof.weatherapp.presentation.main_screen.components.WeatherNowComponent
import com.ruskaof.weatherapp.presentation.theme.AppTheme

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    var circle1SizeState by remember { mutableStateOf(0.dp) }
    var circle2SizeState by remember { mutableStateOf(0.dp) }
    val circle1Size by animateDpAsState(targetValue = circle1SizeState, animationSpec = tween(1000))
    val circle2Size by animateDpAsState(targetValue = circle2SizeState, animationSpec = tween(1000))
    val circleColor1 = AppTheme.colors.circleColor1
    val circleColor2 = AppTheme.colors.circleColor2

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
            circle1SizeState = 500.dp
            circle2SizeState = 300.dp
            WeatherNowComponent(viewModel.weatherNowState.value)
//            {
//                viewModel.getCurrentWeather("Saint Petersburg")
//            }
            WeatherFullComponent(viewModel.weatherFullState.value.fullForecast)
        }
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .size(40.dp),
        contentAlignment = Alignment.TopEnd
    ) {

        Image(
            painter = painterResource(R.drawable.ic_round_refresh_24),
            modifier = Modifier
                .size(50.dp)
                .clickable {
                    viewModel.getCurrentWeather("Saint Petersburg")
                },
            colorFilter = ColorFilter.tint(AppTheme.typography.locationTextStyle.color),
            contentDescription = "Refresh icon"
        )
    }
}