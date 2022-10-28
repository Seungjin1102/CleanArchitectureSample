package com.example.launchproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.launchproject.view.weather.WeatherActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("sbandTest", "onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun btnClick(view: View) {
        when (view.id) {
            R.id.weather -> {
                startActivity(Intent(this, WeatherActivity::class.java))
            }
            R.id.launch -> {

            }
        }
    }
}