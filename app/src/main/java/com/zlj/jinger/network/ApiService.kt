package com.zlj.jinger.network

import com.zlj.jinger.bean.ArticleVO
import com.zlj.jinger.bean.MusicListVO
import com.zlj.network.MyRetrofitClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path as Path

interface ApiService {
    companion object{
        val apiService=MyRetrofitClient.getRetrofitClient("",ApiService::class.java)

    }

    @GET("wxarticle/chapters/json")
    suspend fun getData(): BaseResponse<List<ArticleVO>>

    @GET("search")
    suspend fun getMusicList(@Query("keywords") keyword:String):MusicListVO
}