package com.zlj.jinger.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zlj.jinger.R
import com.zlj.jinger.adapter.EatAdapter
import kotlinx.android.synthetic.main.fragment_enjoy.*
import kotlinx.android.synthetic.main.fragment_play.*

class PlayGameFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_play,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter(){
        val strList= listOf("手机手机手机","有个游戏叫塞尔达","抓娃娃还是被抓","手残党克星无敌割草","横竖都是二")
        val adapter= EatAdapter(strList)
        rvPlayWhat.adapter=adapter
        rvPlayWhat.layoutManager= LinearLayoutManager(activity)
    }
}