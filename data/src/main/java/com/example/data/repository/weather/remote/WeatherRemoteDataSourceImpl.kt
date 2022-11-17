package com.example.data.repository.weather.remote

import android.util.Log
import com.example.data.api.ApiInterface
import com.example.data.model.weather.WeatherResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRemoteDataSourceImpl(private val apiInterface: ApiInterface) : WeatherRemoteDataSource{
    override suspend fun getWeatherFlow(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        base_date: Int,
        base_time: String,
        nx: String,
        ny: String
    ): Flow<WeatherResponse> {
        Log.d("sbandTest", "WeatherRemoteDataSourceImpl getWeatherFlow() serviceKey: $serviceKey numOfRows: $numOfRows, pageNo: $pageNo, dataType: $dataType, base_date: $base_date, " +
                "base_time: $base_time, nx: $nx, ny: $ny")
        return flow {
            Log.d("sbandTest", "WeatherRemoteDataSourceImpl getWeatherFlow() flow 안")
            emit(apiInterface.getWeatherFlow(serviceKey, numOfRows, pageNo, dataType, base_date, base_time, nx, ny))
        }

    }
}