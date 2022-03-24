package com.ruskaof.weatherapp.presentation.theme


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

val lightTextTypography = AppTypography(
    biggerTextStyle = TextStyle(color = Color.White, fontSize = 50.sp),
    primaryTextStyle = TextStyle(color = Color.White, fontSize = 40.sp),
    smallerTextStyle = TextStyle(color = Color.White, fontSize = 30.sp),
    tinyTextStyle = TextStyle(color = Color.White, fontSize = 20.sp)
)

val darkTextTypography = AppTypography(
    biggerTextStyle = TextStyle(color = Color.White, fontSize = 100.sp),
    primaryTextStyle = TextStyle(color = Color.White, fontSize = 30.sp),
    smallerTextStyle = TextStyle(color = Color.White, fontSize = 20.sp),
    tinyTextStyle = TextStyle(color = Color.White, fontSize = 10.sp)
)