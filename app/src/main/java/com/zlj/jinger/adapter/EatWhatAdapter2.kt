package com.zlj.jinger.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zlj.jinger.R

class EatWhatAdapter2 (var context: Context,var mDataList: List<String>): RecyclerView.Adapter<EatWhatAdapter2.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.item_ear_what,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        mDataList?.let {
            return  it.size
        }
        return  0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv_eat_what.text= mDataList[position]
    }

     class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tv_eat_what=itemView.findViewById<TextView>(R.id.tv_eat_what)
    }


}