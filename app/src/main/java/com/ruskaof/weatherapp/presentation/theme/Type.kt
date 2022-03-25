package com.ruskaof.weatherapp.presentation.theme


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// TODO: make a light theme colors
val lightTextTypography = AppTypography(
    mainTemperatureDegreeStyle = TextStyle(color = Color.White, fontSize = 50.sp),
    locationTextStyle = TextStyle(color = Color.White, fontSize = 40.sp),
    inListTemperatureDegreeStyle = TextStyle(color = Color.White, fontSize = 30.sp),
    inListDateStyle = TextStyle(color = Color.White, fontSize = 20.sp),
    nowWeatherConditionStyle = TextStyle(
        color = Color.White,
        fontSize = 30.sp,
        fontWeight = FontWeight.Thin
    ),
    inListWeatherConditionStyle = TextStyle(
        color = Color.White,
        fontSize = 15.sp,
        fontWeight = FontWeight.Thin
    )
)

val darkTextTypography = AppTypography(
    mainTemperatureDegreeStyle = TextStyle(
        color = Color.White,
        fontSize = 100.sp,
        fontWeight = FontWeight.ExtraLight
    ),
    locationTextStyle = TextStyle(
        color = Color.White,
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    inListTemperatureDegreeStyle = TextStyle(
        color = Color.White,
        fontSize = 50.sp,
        fontWeight = FontWeight.ExtraLight
    ),
    inListDateStyle = TextStyle(
        color = Color.White,
        fontSize = 30.sp,
        fontWeight = FontWeight.Light
    ),
    nowWeatherConditionStyle = TextStyle(
        color = Color.White,
        fontSize = 30.sp,
        fontWeight = FontWeight.Thin
    ),
    inListWeatherConditionStyle = TextStyle(
        color = Color.White,
        fontSize = 15.sp,
        fontWeight = FontWeight.Thin
    )
)