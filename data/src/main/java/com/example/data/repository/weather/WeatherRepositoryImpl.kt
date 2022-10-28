package com.example.data.repository.weather

import android.util.Log
import com.example.data.api.KtorInterface
import com.example.data.mapper.mapperToWeather
import com.example.domain.model.Weather
import com.example.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val ktorInterface: KtorInterface
) : WeatherRepository {

    override fun getWeatherFlow(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        base_date: Int,
        base_time: Int,
        nx: String,
        ny: String
    ): Flow<List<Weather>> {
        Log.d("sbandTest", "getWeatherFlow()")
        Log.d("sbandTest", "serviceKey: $serviceKey numOfRows: $numOfRows, pageNo: $pageNo, dataType: $dataType, base_date: $base_date, " +
                "base_time: $base_time, nx: $nx, ny: $ny")
        return flow {
            ktorInterface.requestWeatherData(
                serviceKey,
                numOfRows,
                pageNo,
                dataType,
                base_date,
                base_time,
                nx,
                ny
            ).collect {
                Log.d("sbandTest", "it: $it")
                emit(mapperToWeather(it.response.body.items))
            }
        }
    }


}