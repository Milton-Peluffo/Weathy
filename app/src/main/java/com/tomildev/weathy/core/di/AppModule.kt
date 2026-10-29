package com.tomildev.weathy.core.di

import com.tomildev.weathy.core.data.remote.ApiConstants
import com.tomildev.weathy.core.data.remote.WeatherApi
import com.tomildev.weathy.core.data.repository.WeatherRepositoryImpl
import com.tomildev.weathy.core.domain.repository.WeatherRepository
import com.tomildev.weathy.core.domain.use_case.GetWeatherDataUseCase
import com.tomildev.weathy.core.domain.use_case.WeathyUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideWeathyUseCases(weatherRepository: WeatherRepository): WeathyUseCases {
        return WeathyUseCases(
            getWeatherDataUseCase = GetWeatherDataUseCase(weatherRepository)
        )
    }

}