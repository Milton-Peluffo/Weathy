package com.tomildev.core.data.repository

import com.tomildev.core.data.mapper.toWeatherInfo
import com.tomildev.core.data.remote.RetrofitClient
import com.tomildev.core.data.remote.WeatherApi
import com.tomildev.core.domain.model.WeatherInfo
import com.tomildev.core.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val api: WeatherApi = RetrofitClient.weatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Result<WeatherInfo> {
        return try {
            val responseDto = this.api.getWeatherData(
                latitude = lat,
                longitude = long
            )
            val weatherInfo = responseDto.toWeatherInfo()
            Result.success(weatherInfo)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}