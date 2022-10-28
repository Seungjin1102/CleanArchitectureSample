package com.example.launchproject.view.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.weather.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {


    fun requestWeatherFlow() {
        Log.d("sbandTest", "requestWeatherFlow()")
        viewModelScope.launch {
            getWeatherUseCase.getFlowData(
                "vBSaC%2BkyE6C95EsFZP4cO8R4MxYno8npQ3T3CDGifWUt8dPNtm2amOvtZo%2FkBHJQ9S7IdpPvb0E%2Bj95bneoHJA%3D%3D",
                10,
                1,
                "JSON",
            20221028,
            1400,
                "55",
                "127"
            )
        }
    }
}