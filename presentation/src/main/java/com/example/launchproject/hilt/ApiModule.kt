package com.example.launchproject.hilt

import android.util.Log
import com.example.data.api.ApiClient
import com.example.data.api.ApiInterface
import com.example.launchproject.BuildConfig
import com.google.gson.GsonBuilder
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        Log.d("sbandTest", "provideApiInterface()")
        return retrofit.create(ApiInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        Log.d("sbandTest", "provideRetrofit()")
        return Retrofit.Builder()
            .baseUrl(ApiClient.BASE_URL)
            .client(okHttpClient)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // Rx도 사용하기 때문에 추가 필요.
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        headerInterceptor: Interceptor,
        LoggerInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        Log.d("sbandTest", "provideOkHttpClient()")

        val okHttpClientBuilder = OkHttpClient().newBuilder()
        okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.writeTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.addInterceptor(headerInterceptor)
        okHttpClientBuilder.addInterceptor(LoggerInterceptor)

        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideHeaderInterceptor(): Interceptor {
        Log.d("sbandTest", "provideHeaderInterceptor()")
        return Interceptor { chain ->
            with(chain) {
                val newRequest = request().newBuilder()
                    .build()
                proceed(newRequest)
            }
        }
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        Log.d("sbandTest", "provideLoggingInterceptor()")
        return HttpLoggingInterceptor { message ->
            Logger.d(message)
        }.let {
            if (BuildConfig.DEBUG) {
                Logger.addLogAdapter(AndroidLogAdapter())
                it.setLevel(HttpLoggingInterceptor.Level.BODY)
            } else {
                it.setLevel(HttpLoggingInterceptor.Level.NONE)
            }
        }
    }


//    @Singleton
//    @Provides
//    fun provideHttpClient(): HttpClient { //이거사용
//        Log.d("sbandTest", "provideHttpClient()")
//        return HttpClient(CIO) {
////            install(Logging) {
////                logger = object : Logger {
////                    override fun log(message: String) {
////                        Log.d("sbandTest", "*message : $message")
////                    }
////                }
////                level = LogLevel.ALL
////            }
//
//            install(ContentNegotiation) {
//                json(Json {
//                    ignoreUnknownKeys = true
//                    isLenient = true
//                    encodeDefaults = true
//                })
//            }
//
//            install(HttpTimeout) {
//                connectTimeoutMillis = 6000
//                requestTimeoutMillis = 6000
//                socketTimeoutMillis = 6000
//            }
//
//            defaultRequest {
//                contentType(ContentType.Application.Json)
////                headers {
////                    append("X-Naver-Client-Id", "33chRuAiqlSn5hn8tIme")
////                    append("X-Naver-Client-Secret", "fyfwt9PCUN")
////                }
//            }
//        }
//    }
}