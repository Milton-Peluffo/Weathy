package com.tomildev.weathy.features.mainview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tomildev.weathy.core.domain.use_case.WeathyUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewViewModel @Inject constructor(
    private val weathyUseCases: WeathyUseCases
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