package com.example.launchproject.view.weather

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.api.ApiClient
import com.example.domain.model.Weather
import com.example.domain.usecase.weather.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _weatherList = MutableLiveData<MutableList<Weather>>()
    val weatherList : LiveData<MutableList<Weather>> get() = _weatherList


    fun requestWeatherFlow() {
        Log.d("sbandTest", "requestWeatherFlow()")
        viewModelScope.launch {
            getWeatherUseCase.getFlowData(
                ApiClient.SERVICE_KEY,
                12,
                1,
                "JSON",
                 getCurrentDay(),
                getCurrentTime(),
                "55",
                "127"
            ).onStart { Log.d("sbandTest", "WeatherViewModel requestWeatherFlow() 코루틴 start") }
                .onCompletion { Log.d("sbandTest", "WeatherViewModel requestWeatherFlow() 코루틴 completion") }
                .catch {
                    Log.d("sbandTest", "WeatherViewModel requestWeatherFlow() 코루틴 fail")
                }
                .collect { weather ->
                    _weatherList.value = weather.toMutableList()
                    Log.d("sbandTest", "WeatherViewModel collevt weatherList: ${_weatherList.value}")
                }
        }
    }

    fun getCurrentDay(): Int {
        val current = LocalDateTime.now()
        val formatted = current.format(DateTimeFormatter.ISO_DATE).replace("-", "").toInt()
        Log.d("sbandTest", "getCurrentDay() 현재날짜 : $formatted")
        return formatted
    }

    fun getCurrentTime(): Int {
        val current = LocalDateTime.now()
        val formatted = (current.format(DateTimeFormatter.ISO_LOCAL_TIME).replace(":", "").substring(0, 4)
            .toInt() / 100) * 100
        var time = 1100
        if (formatted > 1100) {
            val timeList = listOf(1100, 1400, 1700, 2000, 2300)
            timeList.forEach {
                if (formatted >= it) time = it
            }

        }
        Log.d("sbandTest", "getCurrentTime() formatted: $formatted time: $time")
        return time
    }
}