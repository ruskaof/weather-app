package com.ruskaof.weatherapp.presentation.main_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ruskaof.weatherapp.common.Constants
import com.ruskaof.weatherapp.presentation.main_screen.MainScreenViewModel
import com.ruskaof.weatherapp.presentation.theme.AppTheme

@Composable
fun ChangeLocationDialog(
    viewModel: MainScreenViewModel
) {
    var textFieldState by remember { mutableStateOf("") }
    AlertDialog(
        backgroundColor = AppTheme.colors.primaryBackground,
        onDismissRequest = { viewModel.closeDialog() },
        buttons = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                OutlinedButton(
                    onClick = {
                        if (textFieldState != "") {
                            viewModel.changeLocation(textFieldState)
                            viewModel.getCurrentWeather(Constants.locationState.value)
                            viewModel.getFullForecast(4, Constants.locationState.value)
                            viewModel.closeDialog()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = AppTheme.colors.primaryBackground)
                ) {
                    Text(
                        text = "Ok",
                        style = AppTheme.typography.inListWeatherConditionStyle.copy(fontWeight = FontWeight.Normal)
                    )
                }
            }
        },
        text = {
            Column(
                modifier = Modifier.padding()
            ) {
                OutlinedTextField(
                    value = textFieldState,
                    onValueChange = {
                        textFieldState = it
                    },
                    label = {
                        Text(
                            text = "Enter new location",
                            style = AppTheme.typography.inListWeatherConditionStyle.copy(fontWeight = FontWeight.Normal)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = AppTheme.colors.circleColor1,
                        cursorColor = AppTheme.colors.circleColor1
                    )
                )
            }
        },
    )
}