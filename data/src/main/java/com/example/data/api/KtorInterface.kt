package com.example.data.api

import com.example.data.model.weather.WeatherResponse
import kotlinx.coroutines.flow.Flow

interface KtorInterface {

    suspend fun requestWeatherData(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        base_date: Int,
        base_time: Int,
        nx: String,
        ny: String
    ): Flow<WeatherResponse>
}