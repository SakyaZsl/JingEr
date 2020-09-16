package com.zlj.jinger.network

import com.zlj.jinger.bean.ArticleVO
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("wxarticle/chapters/json")
    fun getData(): Call<BaseResponse<List<ArticleVO>>>
}