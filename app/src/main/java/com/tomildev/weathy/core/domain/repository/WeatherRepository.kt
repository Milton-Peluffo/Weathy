package com.tomildev.weathy.core.domain.repository

import com.tomildev.weathy.core.domain.model.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Result<WeatherInfo>
}