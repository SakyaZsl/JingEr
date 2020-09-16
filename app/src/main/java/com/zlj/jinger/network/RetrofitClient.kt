package com.zlj.jinger.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  RetrofitClient {

    const val BASE_URL="https://wanandroid.com/"

    val reqApi: ApiService by lazy{
        val retrofit=Retrofit.Builder().
        baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        return@lazy retrofit.create(ApiService::class.java)

    }
}