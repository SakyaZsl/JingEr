package com.zlj.jinger.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import androidx.fragment.app.Fragment
import com.zlj.jinger.R
import kotlinx.android.synthetic.main.fragment_eat.*


class EatFragment:Fragment() {
    companion object{
        const val url="https://www.ele.me/"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_eat,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initWebSetting()
        wvEat.loadUrl(url)
    }

    private fun  initWebSetting(){

    //声明WebSettings子类


    //声明WebSettings子类
        val webSettings: WebSettings = wvEat.getSettings()


    //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript


    //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.javaScriptEnabled = true


    //支持插件

        //设置自适应屏幕，两者合用

        //设置自适应屏幕，两者合用
        webSettings.useWideViewPort = true //将图片调整到适合webview的大小


        webSettings.loadWithOverviewMode = true // 缩放至屏幕的大小


    //缩放操作


        //缩放操作
        webSettings.setSupportZoom(true) //支持缩放，默认为true。是下面那个的前提。


        webSettings.builtInZoomControls = true //设置内置的缩放控件。若为false，则该WebView不可缩放


        webSettings.displayZoomControls = false //隐藏原生的缩放控件


        //其他细节操作
        webSettings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK //关闭webview中缓存


        webSettings.allowFileAccess = true //设置可以访问文件


        webSettings.javaScriptCanOpenWindowsAutomatically = true //支持通过JS打开新窗口


        webSettings.loadsImagesAutomatically = true //支持自动加载图片


        webSettings.defaultTextEncodingName = "utf-8" //设置编码格式

    }
}