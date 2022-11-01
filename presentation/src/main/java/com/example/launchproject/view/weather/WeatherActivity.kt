package com.example.launchproject.view.weather

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.launchproject.R
import com.example.launchproject.base.BaseActivity
import com.example.launchproject.databinding.ActivityWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity : BaseActivity<ActivityWeatherBinding>(R.layout.activity_weather) {

    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var weatherAdapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.weather = viewModel
        initAdapter()
        viewModel.weatherList.observe(this@WeatherActivity, Observer {
            Log.d("sbandTest", "observer 안 it: $it")
            weatherAdapter.data = it
            weatherAdapter.notifyDataSetChanged()
        })
    }

    private fun initAdapter() {
        Log.d("sbandTest", "WeatherActivity initAdapter()")
        weatherAdapter = WeatherAdapter(
            context = applicationContext
        )
        binding.recyclerview.adapter = weatherAdapter
    }
}