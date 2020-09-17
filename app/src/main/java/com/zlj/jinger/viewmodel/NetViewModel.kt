package com.zlj.jinger.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zlj.jinger.bean.ArticleVO
import com.zlj.jinger.bean.Song
import com.zlj.jinger.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.await

class NetViewModel :ViewModel() {
    var liveData=MutableLiveData<List<ArticleVO>>()

    var musicLiveData=MutableLiveData<List<Song>>()

    fun getData(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val data= RetrofitClient.reqApi.getData()
                data?.let {
                    liveData.postValue(it.data)
                }
            }
        }
    }

    fun  getMusicList(name:String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                var data=RetrofitClient.musicApi.getMusicList(name)
                data?.result?.songs?.let {
                    musicLiveData.postValue(it)
                }
            }
        }
    }
}