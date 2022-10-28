package com.example.launchproject.hilt

import com.example.data.api.KtorInterface
import com.example.data.repository.weather.WeatherRepositoryImpl
import com.example.data.repository.weather.ktor.KtorInterfaceImpl
import com.example.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideKtorInterface(client: HttpClient): KtorInterface {
        return KtorInterfaceImpl(client)
    }

    @Singleton
    @Provides
    fun provideWeatherRepository(
        ktorInterface: KtorInterface,
    ): WeatherRepository {
        return WeatherRepositoryImpl(ktorInterface)
    }

}