package com.tomildev.weathy.core.domain.model

import androidx.annotation.DrawableRes
import com.tomildev.weathy.ui.theme.WeathyDrawables

sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes: Int,
    @DrawableRes val backgroundRes: Int
) {
    object ClearSky : WeatherType(
        weatherDesc = "Despejado",
        iconRes = WeathyDrawables.Icons.ClearSky,
        backgroundRes = WeathyDrawables.Backgrounds.ClearSky
    )

    object MainlyClear : WeatherType(
        weatherDesc = "Principalmente despejado",
        iconRes = WeathyDrawables.Icons.MainlyClear,
        backgroundRes = WeathyDrawables.Backgrounds.MainlyClear
    )

    object PartlyCloudy : WeatherType(
        weatherDesc = "Parcialmente nublado",
        iconRes = WeathyDrawables.Icons.PartlyCloudy,
        backgroundRes = WeathyDrawables.Backgrounds.PartlyCloudy
    )

    object Overcast : WeatherType(
        weatherDesc = "Nublado",
        iconRes = WeathyDrawables.Icons.Overcast,
        backgroundRes = WeathyDrawables.Backgrounds.Overcast
    )

    object Fog : WeatherType(
        weatherDesc = "Niebla / Foggy",
        iconRes = WeathyDrawables.Icons.Fog,
        backgroundRes = WeathyDrawables.Backgrounds.Fog
    )

    object DepositingRimeFog : WeatherType(
        weatherDesc = "Niebla escarchada",
        iconRes = WeathyDrawables.Icons.DepositingRimeFog,
        backgroundRes = WeathyDrawables.Backgrounds.DepositingRimeFog
    )

    object LightDrizzle : WeatherType(
        weatherDesc = "Llovizna ligera",
        iconRes = WeathyDrawables.Icons.LightDrizzle,
        backgroundRes = WeathyDrawables.Backgrounds.LightDrizzle
    )

    object ModerateDrizzle : WeatherType(
        weatherDesc = "Llovizna moderada",
        iconRes = WeathyDrawables.Icons.ModerateDrizzle,
        backgroundRes = WeathyDrawables.Backgrounds.ModerateDrizzle
    )

    object DenseDrizzle : WeatherType(
        weatherDesc = "Llovizna densa",
        iconRes = WeathyDrawables.Icons.DenseDrizzle,
        backgroundRes = WeathyDrawables.Backgrounds.DenseDrizzle
    )

    object LightFreezingDrizzle : WeatherType(
        weatherDesc = "Llovizna helada ligera",
        iconRes = WeathyDrawables.Icons.LightFreezingDrizzle,
        backgroundRes = WeathyDrawables.Backgrounds.LightFreezingDrizzle
    )

    object DenseFreezingDrizzle : WeatherType(
        weatherDesc = "Llovizna helada densa",
        iconRes = WeathyDrawables.Icons.DenseFreezingDrizzle,
        backgroundRes = WeathyDrawables.Backgrounds.DenseFreezingDrizzle
    )

    object SlightRain : WeatherType(
        weatherDesc = "Lluvia ligera",
        iconRes = WeathyDrawables.Icons.SlightRain,
        backgroundRes = WeathyDrawables.Backgrounds.SlightRain
    )

    object ModerateRain : WeatherType(
        weatherDesc = "Lluvia moderada",
        iconRes = WeathyDrawables.Icons.ModerateRain,
        backgroundRes = WeathyDrawables.Backgrounds.ModerateRain
    )

    object HeavyRain : WeatherType(
        weatherDesc = "Lluvia fuerte",
        iconRes = WeathyDrawables.Icons.HeavyRain,
        backgroundRes = WeathyDrawables.Backgrounds.HeavyRain
    )

    object LightFreezingRain : WeatherType(
        weatherDesc = "Lluvia congelante ligera",
        iconRes = WeathyDrawables.Icons.LightFreezingRain,
        backgroundRes = WeathyDrawables.Backgrounds.LightFreezingRain
    )

    object HeavyFreezingRain : WeatherType(
        weatherDesc = "Lluvia congelante fuerte",
        iconRes = WeathyDrawables.Icons.HeavyFreezingRain,
        backgroundRes = WeathyDrawables.Backgrounds.HeavyFreezingRain
    )

    object SlightSnowfall : WeatherType(
        weatherDesc = "Nevada ligera",
        iconRes = WeathyDrawables.Icons.SlightSnowfall,
        backgroundRes = WeathyDrawables.Backgrounds.SlightSnowfall
    )

    object ModerateSnowfall : WeatherType(
        weatherDesc = "Nevada moderada",
        iconRes = WeathyDrawables.Icons.ModerateSnowfall,
        backgroundRes = WeathyDrawables.Backgrounds.ModerateSnowfall
    )

    object HeavySnowfall : WeatherType(
        weatherDesc = "Nevada fuerte",
        iconRes = WeathyDrawables.Icons.HeavySnowfall,
        backgroundRes = WeathyDrawables.Backgrounds.HeavySnowfall
    )

    object SnowGrains : WeatherType(
        weatherDesc = "Granizo fino",
        iconRes = WeathyDrawables.Icons.SnowGrains,
        backgroundRes = WeathyDrawables.Backgrounds.SnowGrains
    )

    object SlightRainShowers : WeatherType(
        weatherDesc = "Chubascos ligeros",
        iconRes = WeathyDrawables.Icons.SlightRainShowers,
        backgroundRes = WeathyDrawables.Backgrounds.SlightRainShowers
    )

    object ModerateRainShowers : WeatherType(
        weatherDesc = "Chubascos moderados",
        iconRes = WeathyDrawables.Icons.ModerateRainShowers,
        backgroundRes = WeathyDrawables.Backgrounds.ModerateRainShowers
    )

    object ViolentRainShowers : WeatherType(
        weatherDesc = "Chubascos violentos",
        iconRes = WeathyDrawables.Icons.ViolentRainShowers,
        backgroundRes = WeathyDrawables.Backgrounds.ViolentRainShowers
    )

    object SlightSnowShowers : WeatherType(
        weatherDesc = "Chubascos de nieve ligeros",
        iconRes = WeathyDrawables.Icons.SlightSnowShowers,
        backgroundRes = WeathyDrawables.Backgrounds.SlightSnowShowers
    )

    object HeavySnowShowers : WeatherType(
        weatherDesc = "Chubascos de nieve fuertes",
        iconRes = WeathyDrawables.Icons.HeavySnowShowers,
        backgroundRes = WeathyDrawables.Backgrounds.HeavySnowShowers
    )

    object Thunderstorm : WeatherType(
        weatherDesc = "Tormenta eléctrica",
        iconRes = WeathyDrawables.Icons.Thunderstorm,
        backgroundRes = WeathyDrawables.Backgrounds.Thunderstorm
    )

    object ThunderstormWithSlightHail : WeatherType(
        weatherDesc = "Tormenta con granizo ligero",
        iconRes = WeathyDrawables.Icons.ThunderstormWithSlightHail,
        backgroundRes = WeathyDrawables.Backgrounds.ThunderstormWithSlightHail
    )

    object HeavyThunderstorm : WeatherType(
        weatherDesc = "Tormenta eléctrica fuerte",
        iconRes = WeathyDrawables.Icons.HeavyThunderstorm,
        backgroundRes = WeathyDrawables.Backgrounds.HeavyThunderstorm
    )

    object ThunderstormWithHeavyHail : WeatherType(
        weatherDesc = "Tormenta con granizo fuerte",
        iconRes = WeathyDrawables.Icons.ThunderstormWithHeavyHail,
        backgroundRes = WeathyDrawables.Backgrounds.ThunderstormWithHeavyHail
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Fog
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingRain
                67 -> HeavyFreezingRain
                71 -> SlightSnowfall
                73 -> ModerateSnowfall
                75 -> HeavySnowfall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> Thunderstorm
                96 -> ThunderstormWithSlightHail
                97 -> HeavyThunderstorm
                99 -> ThunderstormWithHeavyHail
                else -> ClearSky
            }
        }
    }
}
