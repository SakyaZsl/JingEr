package com.zlj.jinger.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zlj.jinger.R
import com.zlj.jinger.adapter.EatAdapter
import kotlinx.android.synthetic.main.fragment_drink.*
import kotlinx.android.synthetic.main.fragment_eat.*

class DrinkFragment :Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_drink,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter(){
        val strList= listOf("酸酸甜甜就是我","快乐肥宅两不误","奶茶我要不胖的","不要这个要那个冰淇淋","汤汤汤汤烫烫烫烫")
        val adapter= EatAdapter(strList)
        rvDrinkWhat.adapter=adapter
        rvDrinkWhat.layoutManager= LinearLayoutManager(activity)
    }
}