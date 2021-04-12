package com.zlj.jinger.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.zlj.jinger.R
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class LuckyActivity:AppCompatActivity() {
    private var index=0

    companion object{
        val titleList= listOf("干饭人干饭魂","肥宅快乐源泉","游戏人生","不上班最快乐")
        private val eatList= listOf("土豆","烤鱼","串串","炸鸡","烤肉","烧烤","回家吃","冒菜")
        private val drinkList= listOf("没灵魂的阔乐","透心凉心飞扬","酸酸甜甜我最爱","红绿白黑茶","82年的凉白开","我要超大杯","星弟弟专属","这水没你甜")
        private val playList= listOf("手机","手机","手机","手机","手机","手机","手机","手机")
        private val enjoyList= listOf("死宅","旅游","死宅","旅游","死宅","旅游","死宅","旅游")
        val allList= listOf(eatList, drinkList, playList, enjoyList)
        const val TAG_INDEX="tag_index"
        fun startAction(context: Context,index:Int){
            context.startActivity(Intent(context, LuckyActivity::class.java)
                    .apply {
                        putExtra(TAG_INDEX,index)
                    })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        initView()
    }


    private fun initView(){
        index=intent.getIntExtra(TAG_INDEX,0)
        tvTitle.text= titleList[index]
        btn_action.setOnClickListener(View.OnClickListener {
            if (!lucky_panel.isGameRunning) {
                lucky_panel.startGame()
            } else {
                val stayIndex = Random().nextInt(8)
                Log.e("LuckyMonkeyPanelView", "====stay===$stayIndex")
                lucky_panel.tryToStop(stayIndex)
                GlobalScope.launch {
                    delay(1500)
                    tvEatWhat.text= allList[index][stayIndex]
                }
            }
        })
    }


}