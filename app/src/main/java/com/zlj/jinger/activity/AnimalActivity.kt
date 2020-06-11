package com.zlj.jinger.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zlj.jinger.R
import kotlinx.android.synthetic.main.activity_animal.*

class AnimalActivity  :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)
        val model =ViewModelProvider(this)[AnimalViewModel::class.java]
        model.userData.observe(this, Observer {
            info_tv.text = "姓名：${it.name} \n薪水：${it.shoutCount}"
        })
        action_btn.setOnClickListener { model.getAnimal() }
    }

}