package com.zlj.jinger.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zlj.jinger.bean.Animal

class AnimalViewModel: ViewModel() {
    var userData:MutableLiveData<Animal> = MutableLiveData()

    fun getAnimal(){
        var animal=Animal("狗",(1000..5000).random())
        userData.postValue(animal)
    }
}