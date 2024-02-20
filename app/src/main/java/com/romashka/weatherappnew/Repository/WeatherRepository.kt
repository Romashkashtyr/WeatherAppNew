package com.romashka.weatherappnew.Repository

import com.romashka.weatherappnew.Server.ApiServices

class WeatherRepository(val api: ApiServices) {

    fun getCurrentWeather(lat: Double, lng: Double, unit: String) =
        api.getCurrentWeather(lat, lng, unit, "1f8c76634fbcb6d96791da5e044c13ae")

    fun getForecastWeather(lat: Double, lng: Double, unit: String) =
        api.getForecastWeather(lat, lng, unit, "1f8c76634fbcb6d96791da5e044c13ae")
}