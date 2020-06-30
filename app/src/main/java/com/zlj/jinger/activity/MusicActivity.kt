package com.zlj.jinger.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.zlj.jinger.bean.BaseBean
import kotlinx.android.synthetic.main.activity_music.*



class MusicActivity :AppCompatActivity() {
    val TAG="zzzz"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.zlj.jinger.R.layout.activity_eat)
        initView()
    }


    fun initView(){
        val listener=object :View.OnClickListener{
            override fun onClick(v: View?) {
              Log.e("zzzz","这个是${A.C}")
            }
        }
        btn_play.setOnClickListener(listener)
        val bean= BaseBean(18,"川建国")
        Log.e(TAG,"姓名是${bean.name}年龄是${bean.age}")
    }

    override fun <T : View> findViewById(id: Int): T? {
        return if (id == 0) {
            this as T
        } else null
    }


    class A {
        companion object B{
            var C:Int =10086
        }
    }

}