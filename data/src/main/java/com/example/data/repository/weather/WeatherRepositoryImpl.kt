package com.example.data.repository.weather

import android.util.Log
import com.example.data.mapper.mapperToWeather
import com.example.data.repository.weather.remote.WeatherRemoteDataSource
import com.example.domain.model.Weather
import com.example.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl(
    private val weatherRemoteDataSource: WeatherRemoteDataSource
) : WeatherRepository {

    override fun getWeatherFlow(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        base_date: Int,
        base_time: String,
        nx: String,
        ny: String
    ): Flow<List<Weather>> {
        Log.d("sbandTest", "WeatherRepositoryImpl getWeatherFlow()")
        Log.d("sbandTest", "serviceKey: $serviceKey numOfRows: $numOfRows, pageNo: $pageNo, dataType: $dataType, base_date: $base_date, " +
                "base_time: $base_time, nx: $nx, ny: $ny")
        return flow {
            Log.d("sbandTest", "WeatherRepositoryImpl getWeatherFlow() flow 안")
            weatherRemoteDataSource.getWeatherFlow(serviceKey, numOfRows, pageNo, dataType, base_date, base_time, nx, ny).collect {
                Log.d("sbandTest", "WeatherRepositoryImpl getWeatherFlow() 맵핑전 it: $it")
                emit(mapperToWeather(it.response.body.items))
            }
        }
    }


}