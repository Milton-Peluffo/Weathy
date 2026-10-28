package com.tomildev.features.mainview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tomildev.core.data.repository.WeatherRepositoryImpl
import com.tomildev.core.domain.repository.WeatherRepository
import com.tomildev.core.domain.use_case.GetWeatherDataUseCase
import com.tomildev.core.domain.use_case.WeathyUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewViewModel(
    private val weatherRepository: WeatherRepository = WeatherRepositoryImpl(),
    private val weathyUseCases: WeathyUseCases = WeathyUseCases(
        GetWeatherDataUseCase(
            weatherRepository
        )
    ),
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainViewUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadWeatherInfo()
    }

    fun loadWeatherInfo() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            val result = weathyUseCases.getWeatherDataUseCase(
                lat = 10.3997,
                long = -75.5141
            )

            result.onSuccess { weatherInfo ->
                _uiState.update {
                    it.copy(
                        weatherInfo = weatherInfo,
                        isLoading = false,
                        error = null
                    )
                }
            }.onFailure { exception ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = exception.message ?: "chanfles"
                    )
                }
            }
        }
    }
}