package com.example.domain.usecase.weather

import com.example.domain.model.Weather
import com.example.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(private val repository: WeatherRepository) {
    fun getFlowData(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        base_date: Int,
        base_time: Int,
        nx: String,
        ny: String
    ): Flow<List<Weather>> = repository.getWeatherFlow(
        serviceKey,
        numOfRows,
        pageNo,
        dataType,
        base_date,
        base_time,
        nx,
        ny
    )
}