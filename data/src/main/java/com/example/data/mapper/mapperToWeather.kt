package com.example.data.mapper

import com.example.data.model.weather.Item
import com.example.data.model.weather.WeatherEntity
import com.example.domain.model.Weather

fun mapperToWeather(items: List<WeatherEntity>): List<Weather> {
    return items.toList().map {
        Weather(
            it.fcstValue,
            it.category
        )
    }
}