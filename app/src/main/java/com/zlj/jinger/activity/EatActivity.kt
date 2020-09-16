package com.zlj.jinger.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zlj.jinger.R
import com.zlj.jinger.adapter.EatWhatAdapter2
import kotlinx.android.synthetic.main.activity_eat.*

class EatActivity :AppCompatActivity(){

    companion object{
        fun startAction(context: Context){
            val intent= Intent(context,EatActivity::class.java)
            context.startActivity(intent)
        }
    }

    private var  mAdapter:EatWhatAdapter2?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eat)
        iv_back.setOnClickListener{
            finish()
        }
        initView()
    }

    private fun initView(){
        val list:MutableList<String> = ArrayList()
        list.add("吃烤串")
        list.add("吃串串")
        list.add("吃饭饭")
        list.add("吃面面")
        mAdapter= EatWhatAdapter2(this,list)
        rv_eat_what.adapter=mAdapter
        rv_eat_what.layoutManager= LinearLayoutManager(this)
    }


    fun test(){

    }

}