package com.romashka.weatherappnew.ViewModel

import androidx.lifecycle.ViewModel
import com.romashka.weatherappnew.Repository.WeatherRepository
import com.romashka.weatherappnew.Server.ApiClient
import com.romashka.weatherappnew.Server.ApiServices
import retrofit2.create

class WeatherViewModel(val repository: WeatherRepository): ViewModel() {

    constructor():this(WeatherRepository(ApiClient().getClient().create(ApiServices::class.java)))

    fun loadCurrentWeather(lat: Double, lng: Double, unit: String) =
        repository.getCurrentWeather(lat,lng, unit)
}