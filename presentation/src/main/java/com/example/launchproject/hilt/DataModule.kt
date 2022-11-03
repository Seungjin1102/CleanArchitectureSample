package com.example.launchproject.hilt

import com.example.data.api.ApiInterface
import com.example.data.repository.weather.WeatherRepositoryImpl
import com.example.data.repository.weather.remote.WeatherRemoteDataSource
import com.example.data.repository.weather.remote.WeatherRemoteDataSourceImpl
import com.example.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideRemoteDataSource(apiInterface: ApiInterface): WeatherRemoteDataSource {
        return WeatherRemoteDataSourceImpl(apiInterface)
    }

    @Provides
    fun provideWeatherRepository(
        weatherRemoteDataSource: WeatherRemoteDataSource
    ): WeatherRepository {
        return WeatherRepositoryImpl(weatherRemoteDataSource)
    }

}