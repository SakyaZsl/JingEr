package com.zlj.jinger.network

import com.google.gson.GsonBuilder
import com.haixue.lib.network.base.CustomerGsonTypeAdapterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  RetrofitClient {

    private const val BASE_URL="https://wanandroid.com/"
    private const val BASE_MUSIC_URL="http://musicapi.leanapp.cn/"

    val reqApi: ApiService by lazy{
        val retrofit=Retrofit.Builder().
        baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        return@lazy retrofit.create(ApiService::class.java)

    }

    val musicApi: ApiService by lazy{
        val retrofit=Retrofit.Builder().
        baseUrl(BASE_MUSIC_URL).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .validateEagerly(false)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().registerTypeAdapterFactory(
                        CustomerGsonTypeAdapterFactory()).create()))
                .build()

        return@lazy retrofit.create(ApiService::class.java)

    }

}