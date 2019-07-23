package com.example.stickersampleapp.common

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCreator {
    companion object {
        private const val API_BASE_URL = ""

        private val okHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(getInterceptor())
            .build()

        private val retrofitBuilder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        fun <T> create(service: Class<T>): T {
            return retrofitBuilder.create(service)
        }

        private fun getInterceptor(): HttpLoggingInterceptor {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.NONE
            return interceptor
        }
    }
}