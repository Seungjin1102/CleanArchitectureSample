package com.example.launchproject.hilt

import com.example.data.repository.weather.WeatherRepositoryImpl
import com.example.data.repository.weather.remote.WeatherRemoteDataSource
import com.example.data.repository.weather.remote.WeatherRemoteDataSourceImpl
import com.example.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * 인터페이스 제공 객체 주입 방법은 두가지(@Provides, @Binds)
 * 이 코드에서 @Provides 의 경우 실제 객체를 return -> Impl 클래스에서 @Inject 를 할 필요가 없다
 * @Binds 의 경우 살구현체 클래스(Impl)에서 @Inject 를 해야한다
 */

//@Module
//@InstallIn(SingletonComponent::class)
//abstract class BindingModule {
//
//    @Binds
//    abstract fun bindRemoteDataSource(
//        weatherRemoteDataSourceImpl: WeatherRemoteDataSourceImpl
//    ) : WeatherRemoteDataSource
//
//    @Binds
//    abstract fun bindWeatherRepository(
//        weatherRepositoryImpl: WeatherRepositoryImpl
//    ) : WeatherRepository
//}