package com.ruskaof.weatherapp.domain.use_case

import com.ruskaof.weatherapp.common.Resource
import com.ruskaof.weatherapp.domain.model.NowForecast
import com.ruskaof.weatherapp.domain.model.toNowForecast
import com.ruskaof.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    fun invokeGetNowForecast(location : String) : Flow<Resource<NowForecast>> = flow {
        try {
            emit(Resource.Loading<NowForecast>())
            val loginResponse = repository.getForecastNow(location = location).toNowForecast()
            emit(Resource.Success<NowForecast>(loginResponse))
        } catch (e: HttpException) {
            emit(
                Resource.Error<NowForecast>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error<NowForecast>(
                    e.localizedMessage
                        ?: "Could not reach the server. Please check your internet connection"
                )
            )
        }
    }
}