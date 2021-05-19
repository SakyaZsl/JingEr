package com.zlj.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofitClient {

    @JvmStatic
    fun <T>getRetrofitClient(baseUrl:String ,api:Class<T>):T{
        val retrofit= Retrofit.Builder().
        baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        return retrofit.create(api)
    }

}