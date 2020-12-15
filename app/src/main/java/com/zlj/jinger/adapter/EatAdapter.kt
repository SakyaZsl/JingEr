package com.zlj.jinger.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zlj.jinger.R

class EatAdapter(var dataList:List<String>):RecyclerView.Adapter<EatAdapter.MyViewHolder>() {
    private val imageRes= listOf(R.drawable.icon_eat_five,R.drawable.icon_eat_two,
            R.drawable.icon_eat_three,R.drawable.icon_eat_four,R.drawable.icon_eat_one)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_eat,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvEatWhat.text=dataList[position]
        holder.ivEatWhat.setImageResource(imageRes[position])
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var ivEatWhat: ImageView =itemView.findViewById(R.id.ivEatWhat)
        var tvEatWhat: TextView =itemView.findViewById(R.id.tvEatWhat)
    }
}