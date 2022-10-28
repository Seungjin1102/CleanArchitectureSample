package com.example.data.model.weather

import kotlinx.serialization.Serializable

@Serializable
data class WeatherEntity(
    val baseDate: String,
    val baseTime: String,
    val category: String,
    val fcstDate: String,
    val fcstTime: String,
    val fcstValue: String,
    val nx: Int,
    val ny: Int
)
