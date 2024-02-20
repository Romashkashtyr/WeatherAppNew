package com.romashka.weatherappnew.Server

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    private lateinit var retrofit: Retrofit

    // Если не будет сгенерировано интернет-подключение, считывание данных и отправка запросов, то через 60 с будет выброшено исключение
    private val client = OkHttpClient.Builder()
        .connectTimeout(60,TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    //возвращем экземпляр retrofit, который может работать с http запросами
    fun getClient():Retrofit{
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create()) // конвертер для преобразования json запросов
            .build()
        return retrofit
    }
}