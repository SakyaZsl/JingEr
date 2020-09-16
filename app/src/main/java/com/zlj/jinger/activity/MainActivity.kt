package com.zlj.jinger.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zlj.jinger.R
import com.zlj.jinger.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.await

class MainActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }


    private fun initView(){
        btn_eat_what.setOnClickListener {
            EatActivity.startAction(this)
        }

        btn_drink_what.setOnClickListener {
            test()
        }
    }

    private fun test(){
        GlobalScope.launch(Dispatchers.Main){
            withContext(Dispatchers.IO){
                val data=RetrofitClient.reqApi.getData().await()
                withContext(Dispatchers.Main){
                    tvTest.text=data.toString()
                }
            }

        }
    }


}

