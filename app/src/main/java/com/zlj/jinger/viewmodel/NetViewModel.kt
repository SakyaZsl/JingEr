package com.zlj.jinger.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NetViewModel :ViewModel() {
    var liveData=MutableLiveData<String>()

    fun getData(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){

            }
        }
    }
}