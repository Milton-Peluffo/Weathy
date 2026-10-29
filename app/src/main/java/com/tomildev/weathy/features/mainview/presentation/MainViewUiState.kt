package com.tomildev.weathy.features.mainview.presentation

import com.tomildev.weathy.core.domain.model.WeatherInfo

data class MainViewUiState(
    val weatherInfo: WeatherInfo? = null,
    val cityName: String = "Cartagena de Indias",
    val countryName: String = "Colombia",
    val isLoading: Boolean = false,
    val error: String? = null,
)