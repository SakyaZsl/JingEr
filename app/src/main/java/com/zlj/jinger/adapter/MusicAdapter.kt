package com.zlj.jinger.adapter

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zlj.jinger.R
import com.zlj.jinger.bean.Song

class MusicAdapter (var context: Context, var mDataList: List<Song>): RecyclerView.Adapter<MusicAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view= LayoutInflater.from(context).inflate(R.layout.item_music_detail,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        mDataList?.let {
            return  it.size
        }
        return  0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val bean=mDataList[position]
        holder.tvMusicName.text= bean.name
        var author="哈哈哈"
        var img=""
        bean.artists?.let {
            if (it.isNotEmpty()) {
                var stringBuffer=StringBuffer()
                for (i in it){
                    if(!TextUtils.isEmpty(i.img1v1Url)){
                        img=i.img1v1Url
                    }
                    stringBuffer.append(i.name).append("/")
                }
                stringBuffer.substring(0,stringBuffer.length-1)
                author=stringBuffer.toString()

            }
        }
        holder.tvMusicAuthor.text=author
        Glide.with(context).load(img).into(holder.ivMusicHead)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var ivMusicHead=itemView.findViewById<ImageView>(R.id.ivMusicHead)
        var tvMusicName=itemView.findViewById<TextView>(R.id.tvMusicName)
        var tvMusicAuthor=itemView.findViewById<TextView>(R.id.tvMusicAuthor)
    }


}