package com.example.data.repository.weather.ktor

import android.util.Log
import com.example.data.api.ApiClient
import com.example.data.api.KtorInterface
import com.example.data.model.weather.WeatherResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class KtorInterfaceImpl @Inject constructor(private val client: HttpClient): KtorInterface {
    override suspend fun requestWeatherData(
        serviceKey: String,
        numOfRows: Int,
        pageNo: Int,
        dataType: String,
        base_date: Int,
        base_time: Int,
        nx: String,
        ny: String
    ): Flow<WeatherResponse> {
        Log.d("sbandTest", "serviceKey: $serviceKey numOfRows: $numOfRows, pageNo: $pageNo, dataType: $dataType, base_date: $base_date, " +
                "base_time: $base_time, nx: $nx, ny: $ny")
        return flow {
            emit(client.get(ApiClient.KTOR_WEATHER_BASE_URL) {
                parameter("serviceKey", serviceKey)
                parameter("numOfRows", numOfRows)
                parameter("pageNo", pageNo)
                parameter("dataType", dataType)
                parameter("base_date", base_date)
                parameter("base_time", base_time)
                parameter("nx", nx)
                parameter("ny", ny)
            }.body())
        }

    }

}