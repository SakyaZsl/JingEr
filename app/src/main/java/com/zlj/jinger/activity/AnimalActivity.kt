package com.zlj.jinger.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zlj.jinger.R
import com.zlj.jinger.model.AnimalViewModel
import kotlinx.android.synthetic.main.activity_animal.*

class AnimalActivity  :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)
    }

}