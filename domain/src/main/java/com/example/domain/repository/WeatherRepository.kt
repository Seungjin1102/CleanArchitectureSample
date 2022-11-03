package com.example.domain.repository

import com.example.domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherFlow(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        base_date: Int,
        base_time: String,
        nx: String,
        ny: String
    ): Flow<List<Weather>>
}