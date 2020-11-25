package com.zlj.jinger.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.zlj.jinger.R
import com.zlj.jinger.adapter.MusicAdapter
import com.zlj.jinger.bean.BaseBean
import com.zlj.jinger.bean.Song
import com.zlj.jinger.viewmodel.NetViewModel
import kotlinx.android.synthetic.main.activity_music.*
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MusicActivity :AppCompatActivity() {
    val TAG="zzzz"
    private var mAdapter:MusicAdapter ?=null
    private var mDataList:MutableList<Song> =ArrayList()
    companion object{
        fun startAction(context: Context){
            val intent= Intent(context,MusicActivity::class.java)
            context.startActivity(intent)
        }
    }
    private val viewModels by lazy {
        ViewModelProviders.of(this).get(NetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        initView()
        test()
    }


    private fun initView(){
        viewModels.getMusicList("许嵩")
        viewModels.musicLiveData.observe(this, Observer {
            mDataList.addAll(it)
            mAdapter?.notifyDataSetChanged()
        })
        mAdapter= MusicAdapter(this,mDataList)
        rvMusic.adapter=mAdapter
        rvMusic.layoutManager=LinearLayoutManager(this)

    }


    fun  test(){
        GlobalScope.launch {
            Log.e(TAG, "test: ${Thread.currentThread().name}" )
        }
        GlobalScope.launch(Dispatchers.IO,CoroutineStart.DEFAULT) {
            Log.e(TAG, "test: ${Thread.currentThread().name}" )
        }
        GlobalScope.launch(Dispatchers.Main,CoroutineStart.DEFAULT) {
            Log.e(TAG, "test: ${Thread.currentThread().name}" )
        }
    }


}