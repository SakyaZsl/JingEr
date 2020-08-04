package com.zlj.jinger.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zlj.jinger.R
import com.zlj.jinger.bean.BaseBean



class MusicActivity :AppCompatActivity() {
    val TAG="zzzz"

    val mMusicList= listOf("有何不可","泸州月","玫瑰花的葬礼","素颜","羡慕","清明雨上","如果当时","雅俗共享","断桥残雪","多余的解释","灰色头像","幻听")
    val mIdealList= listOf("有何不可","泸州月","玫瑰花的葬礼","素颜","羡慕")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eat)
        initView()
    }


    private fun initView(){
        val bean= BaseBean(18,"川建国")
        Log.e(TAG,"姓名是${bean.name}年龄是${bean.age}")
    }



}