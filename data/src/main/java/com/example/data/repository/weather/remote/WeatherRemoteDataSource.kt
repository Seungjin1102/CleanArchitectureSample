package com.example.data.repository.weather.remote

import com.example.data.model.weather.WeatherResponse
import kotlinx.coroutines.flow.Flow

interface WeatherRemoteDataSource {
    suspend fun getWeatherFlow(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        base_date: Int,
        base_time: String,
        nx: String,
        ny: String
    ): Flow<WeatherResponse>
}