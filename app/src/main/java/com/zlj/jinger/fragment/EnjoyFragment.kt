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

class EnjoyFragment :Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_enjoy,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter(){
        val strList= listOf("出门出门出门才怪","宅宅宅宅宅宅宅宅","假装自己去旅游","看书看的进入梦乡","实力望穿天花板")
        val adapter= EatAdapter(strList)
        rvEnjoyWhat.adapter=adapter
        rvEnjoyWhat.layoutManager= LinearLayoutManager(activity)
    }
}