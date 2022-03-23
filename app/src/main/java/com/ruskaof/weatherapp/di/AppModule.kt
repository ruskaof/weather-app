package com.ruskaof.weatherapp.di

import com.ruskaof.weatherapp.common.Constants
import com.ruskaof.weatherapp.data.remote.M3oWeatherApi
import com.ruskaof.weatherapp.data.repository.WeatherRepositoryImpl
import com.ruskaof.weatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideM3oWeatherApi() : M3oWeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(M3oWeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: M3oWeatherApi) : WeatherRepository {
        return WeatherRepositoryImpl(api)
    }
}