package com.ruskaof.weatherapp.presentation.theme


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// TODO: make a light theme colors
val lightTextTypography = AppTypography(
    mainTemperatureDegreeStyle = TextStyle(
        color = Color.Black,
        fontSize = 100.sp,
        fontWeight = FontWeight.ExtraLight
    ),
    locationTextStyle = TextStyle(
        color = Color.Black,
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    inListTemperatureDegreeStyle = TextStyle(
        color = Color.Black,
        fontSize = 50.sp,
        fontWeight = FontWeight.ExtraLight
    ),
    inListDateStyle = TextStyle(
        color = Color.Black,
        fontSize = 30.sp,
        fontWeight = FontWeight.Light
    ),
    nowWeatherConditionStyle = TextStyle(
        color = Color.Black,
        fontSize = 30.sp,
        fontWeight = FontWeight.Thin
    ),
    inListWeatherConditionStyle = TextStyle(
        color = Color.Black,
        fontSize = 15.sp,
        fontWeight = FontWeight.Thin
    )
)

val darkTextTypography = AppTypography(
    mainTemperatureDegreeStyle = TextStyle(
        color = Color(0xCCFFFFFF),
        fontSize = 100.sp,
        fontWeight = FontWeight.ExtraLight
    ),
    locationTextStyle = TextStyle(
        color = Color(0xCCFFFFFF),
        fontSize = 30.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    inListTemperatureDegreeStyle = TextStyle(
        color = Color(0xCCFFFFFF),
        fontSize = 50.sp,
        fontWeight = FontWeight.ExtraLight
    ),
    inListDateStyle = TextStyle(
        color = Color(0xCCFFFFFF),
        fontSize = 30.sp,
        fontWeight = FontWeight.Light
    ),
    nowWeatherConditionStyle = TextStyle(
        color = Color(0xCCFFFFFF),
        fontSize = 30.sp,
        fontWeight = FontWeight.Thin
    ),
    inListWeatherConditionStyle = TextStyle(
        color = Color(0xCCFFFFFF),
        fontSize = 15.sp,
        fontWeight = FontWeight.Thin
    )
)