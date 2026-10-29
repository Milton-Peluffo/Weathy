package com.tomildev.weathy.features.mainview.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tomildev.weathy.core.presentation.components.cards.InformationCard
import com.tomildev.weathy.core.presentation.components.spacers.VerticalSpacer
import com.tomildev.weathy.core.presentation.components.texts.Texts
import com.tomildev.weathy.ui.theme.Dimens
import com.tomildev.weathy.ui.theme.WeathyDrawables

@Composable
fun MainViewScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val currentWeather = uiState.weatherInfo?.currentWeather
    val weatherType = currentWeather?.weatherType

    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(Dimens.ScreenHorizontalPadding)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .padding(end = Dimens.SpacingSmall)
                        .size(Dimens.IconSizeLarge),
                    painter = painterResource(WeathyDrawables.Icons.Gps),
                    contentDescription = null,
                    tint = Color(0xFF3b82f6)
                )
                Column(modifier = Modifier.weight(1f)) {
                    Texts.TitleSmall(text = uiState.cityName)
                    Texts.Body(text = uiState.countryName, isSecondary = true)
                }
                IconButton(
                    onClick = { viewModel.loadWeatherInfo() },
                ) {
                    Icon(
                        modifier = Modifier.size(Dimens.IconSizeMedium),
                        painter = painterResource(WeathyDrawables.Icons.Refresh),
                        contentDescription = null,
                        tint = Color(0xFF94a3b8)
                    )
                }
            }
            VerticalSpacer(Dimens.SpacingSmall)
            Box(contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier.zIndex(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Texts.Headline(
                        text = "${currentWeather?.temperature} °C",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Texts.Body(
                        text = "Hoy",
                        color = Color.White,
                        isSecondary = true
                    )
                    VerticalSpacer(Dimens.SpacingSmall)
                    Card(
                        modifier = Modifier,
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainer
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .padding(end = Dimens.SpacingTiny)
                                    .size(Dimens.IconSizeNormal),
                                painter = painterResource(
                                    weatherType?.iconRes ?: WeathyDrawables.Icons.ClearSky
                                ),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                            Texts.Body(
                                text = weatherType?.weatherDesc ?: "Empty",
                            )
                        }
                    }
                }
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(
                        weatherType?.backgroundRes ?: WeathyDrawables.Backgrounds.ClearSky
                    ),
                    contentDescription = null,
                )
            }
            VerticalSpacer(Dimens.SpacingSmall)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InformationCard(
                    icon = WeathyDrawables.Icons.WaterDroplet,
                    iconColor = Color(0xFF3b82f6),
                    data = "${currentWeather?.humidity?.toInt()}%",
                    dataDescription = "Humedad"
                )
                InformationCard(
                    icon = WeathyDrawables.Icons.Wind,
                    iconColor = Color(0xFF2dd4bf),
                    data = "${currentWeather?.windSpeed?.toString()} km/h",
                    dataDescription = "Viento"
                )
                InformationCard(
                    icon = WeathyDrawables.Icons.Pressure,
                    iconColor = Color(0xFFfbbf24),
                    data = "${currentWeather?.pressure?.toInt()} hPa",
                    dataDescription = "Presión"
                )
            }
        }
    }
}