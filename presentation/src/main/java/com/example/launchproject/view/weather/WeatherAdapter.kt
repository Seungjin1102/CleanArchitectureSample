package com.example.launchproject.view.weather


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.domain.model.Weather
import androidx.recyclerview.widget.RecyclerView
import com.example.launchproject.databinding.ItemWeatherBinding

class WeatherAdapter(private val context: Context)
    : RecyclerView.Adapter<WeatherAdapter.ViewHolder>()

{
    var data = listOf<Weather>()
    var mutableMap = mutableMapOf<String, String>()

    init {
        mutableMap.apply {
            this.put("TMP", "기온(TMP)")
            this.put("POP", "강수확률(POP)")
            this.put("PTY", "강수형태(PTY)")
            this.put("REH", "습도(REH)")
            this.put("SNO", "1시간 신적설(SNO)")
            this.put("SKY", "하늘상태(SKY)")
            this.put("PCP", "1시간 강수량(PCP)")
            this.put("TMN", "일 최저기온(TMN)")
            this.put("TMX", "일 최고기온(TMX)")
            this.put("UUU", "풍속(동서)(UUU)")
            this.put("VVV", "풍속(남북)(VVV)")
            this.put("WAV", "파고(WAV)")
            this.put("WSD", "풍속(WSD)")
            this.put("VEC", "풍향(VEC)")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        Log.d("sbandTest", "onCreateViewHolder()")
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Log.d("sbandTest", "onBindViewHolder() data[position: ${data[position]}")
        Log.d("sbandTest", "mutableMap[data[position].category]: ${mutableMap[data[position].category]}")
        val category = mutableMap[data[position].category] ?: ""
        val value = data[position].fcstValue
        holder.bind(category, value)
    }

    override fun getItemCount(): Int {
//        Log.d("sbandTest", "getItemCount() size: ${data.size}")
        return data.size
    }



    class ViewHolder(private val binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: String, value: String) {
            binding.category.text = category
            binding.value.text = value
        }
    }
}

