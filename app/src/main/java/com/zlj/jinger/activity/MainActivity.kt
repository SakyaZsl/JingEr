package com.zlj.jinger.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.zlj.jinger.R
import com.zlj.jinger.network.RetrofitClient
import com.zlj.jinger.viewmodel.NetViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.await

class MainActivity :AppCompatActivity() {

    private val viewModels by lazy {
        ViewModelProviders.of(this).get(NetViewModel::class.java)
    }
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

        btn_listen_what.setOnClickListener {
            MusicActivity.startAction(this)
        }
        viewModels.liveData.observe(this, Observer {
            if(it.isNotEmpty()){
                tvTest.text=it.toString()
            }
        })
    }

    private fun test(){
        viewModels.getData()
    }


}

