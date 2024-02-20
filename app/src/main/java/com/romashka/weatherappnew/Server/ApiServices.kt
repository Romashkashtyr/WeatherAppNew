package com.romashka.weatherappnew.Server

import com.romashka.weatherappnew.model.CurrentResponseApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("data/2.5/weather") // Будет выполнен http запрос типа GET
    fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("apid") ApiKey: String
    ): Call<CurrentResponseApi> // отправка и получение запроса от сервера
}