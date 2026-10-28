package com.tomildev.core.domain.repository

import com.tomildev.core.domain.model.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Result<WeatherInfo>
}