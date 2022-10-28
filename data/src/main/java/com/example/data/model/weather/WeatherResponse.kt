package com.example.data.model.weather

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val response: Response
) {
    @Serializable
    data class Response(
        val header: Header,
        val body: Body
    )

    @Serializable
    data class Header(
        val resultCode: Int,
        val resultMsg: String
    )

    @Serializable
    data class Body(
        val dataType: String,
        val items: List<WeatherEntity>,
        val pageNo: Int,
        val numOfRows: Int,
        val totalCount: Int
    )
}
