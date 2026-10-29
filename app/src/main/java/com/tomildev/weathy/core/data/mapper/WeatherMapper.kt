package com.tomildev.weathy.core.data.mapper

import com.tomildev.weathy.core.data.dto.WeatherResponseDto
import com.tomildev.weathy.core.domain.model.CurrentWeather
import com.tomildev.weathy.core.domain.model.WeatherInfo
import com.tomildev.weathy.core.domain.model.WeatherType

/**
Función de extensión para convertir un objeto WeatherResponseDto en un objeto WeatherInfo.
 */
fun WeatherResponseDto.toWeatherInfo(): WeatherInfo {
    /**
    Obtiene los datos del clima actual del objeto WeatherResponseDto
     */
    val currentData = this.currentWeather

    /*
    Crea un objeto "WeatherInfo" con los datos del clima actual obtenidos de this.currentWeather
    y lo devuelve traducido a modelo de dominio [CurrentWeather].
    */
    return WeatherInfo(
        currentWeather = CurrentWeather(
            temperature = currentData.temperature,
            humidity = currentData.humidity,
            pressure = currentData.pressure,
            windSpeed = currentData.windSpeed,
            weatherType = WeatherType.fromWMO(currentData.weatherCode)
        )
    )
}