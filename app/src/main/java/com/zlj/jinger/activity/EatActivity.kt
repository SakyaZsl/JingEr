package com.zlj.jinger.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zlj.jinger.R
import com.zlj.jinger.adapter.EatWhatAdapter2
import kotlinx.android.synthetic.main.activity_eat.*

class EatActivity :AppCompatActivity(),View.OnClickListener{

    var  mAdapter:EatWhatAdapter2?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eat)
        iv_back.setOnClickListener(this)
        initView()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_back->{
                finish()
            }
            else->{

            }
        }
    }

    fun initView(){
        val list:ArrayList<String> = ArrayList()
        list.add("吃烤串")
        list.add("吃串串")
        list.add("吃饭饭")
        list.add("吃面面")
        mAdapter= EatWhatAdapter2(list,this)
        rv_eat_what.adapter=mAdapter
        rv_eat_what.layoutManager=LinearLayoutManager(this)
    }


}