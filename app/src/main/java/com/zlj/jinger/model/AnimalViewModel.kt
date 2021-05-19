package com.zlj.jinger.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zlj.jinger.bean.Animal
import com.zlj.jinger.network.ApiService
import kotlinx.coroutines.launch

class AnimalViewModel: ViewModel() {
    companion object{
        private const val BASE_URL="https://wanandroid.com/"
        private const val BASE_MUSIC_URL="http://musicapi.leanapp.cn/"
    }
    var userData:MutableLiveData<Animal> = MutableLiveData()

    fun getAnimal(){
        var animal=Animal("狗",(1000..5000).random())
        userData.postValue(animal)
    }

    fun getData(){
        viewModelScope.launch{
            val response=ApiService.apiService.getData()
        }
    }
}