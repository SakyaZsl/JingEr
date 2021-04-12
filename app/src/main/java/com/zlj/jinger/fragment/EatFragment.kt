package com.zlj.jinger.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zlj.jinger.R
import com.zlj.jinger.activity.LuckyActivity
import com.zlj.jinger.adapter.EatAdapter
import kotlinx.android.synthetic.main.fragment_eat.*


class EatFragment : Fragment() {
    companion object {
        const val url = "https://www.ele.me/"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_eat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTest.setOnClickListener {
            LuckyActivity.startAction(requireContext(),0)
        }
        initAdapter()
    }

    private fun initAdapter(){
        val strList= listOf("土豆的一百种吃法","萝卜青菜各有所爱","就跟蔬菜过不去","给我个面子恰面","左刀右叉or左叉右刀")
        val adapter=EatAdapter(strList)
        rvEatWhat.adapter=adapter
        rvEatWhat.layoutManager=LinearLayoutManager(activity)
    }

}