package com.example.data.mapper

import android.util.Log
import com.example.data.model.weather.WeatherResponse
import com.example.domain.model.Weather

fun mapperToWeather(items: WeatherResponse.Items): List<Weather> {
    Log.d("sbandTest", "mapperToWeather() ")

    return items.item.map {
        Weather(
            it.fcstValue,
            it.category
        )
    }

}