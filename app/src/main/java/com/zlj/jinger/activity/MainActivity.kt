package com.zlj.jinger.activity

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.zlj.jinger.R
import com.zlj.jinger.fragment.DrinkFragment
import com.zlj.jinger.fragment.EatFragment
import com.zlj.jinger.fragment.EnjoyFragment
import com.zlj.jinger.fragment.PlayGameFragment
import com.zlj.jinger.network.RetrofitClient
import com.zlj.jinger.viewmodel.NetViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.await

class MainActivity :AppCompatActivity() {
    companion object{
        const val HOME_TAG_EAT=0
        const val HOME_TAG_DRINK=1
        const val HOME_TAG_PLAY=2
        const val HOME_TAG_ENJOY=3
    }
    private val viewModels by lazy {
        ViewModelProviders.of(this).get(NetViewModel::class.java)
    }

    private var _transaction:FragmentTransaction?=null
    private var eatFragment:EatFragment?=null
    private var drinkFragment:DrinkFragment?=null
    private var playFragment:PlayGameFragment?=null
    private var enjoyFragment:EnjoyFragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        test2(100,100)
    }


    private fun initView(){
        changeFragment(HOME_TAG_EAT)
        viewModels.liveData.observe(this, Observer {
            if(it.isNotEmpty()){
            }
        })

        llHomeEat.setOnClickListener {
            changeFragment(HOME_TAG_EAT)
        }
        llHomeDrink.setOnClickListener {
            changeFragment(HOME_TAG_DRINK)
        }
        llHomePlay.setOnClickListener {
            changeFragment(HOME_TAG_PLAY)
        }
        llHomeEnjoy.setOnClickListener {
            changeFragment(HOME_TAG_ENJOY)
        }
    }

    private fun test(){
        viewModels.getData()
        GlobalScope.launch {
            withContext(Dispatchers.IO){

            }

        }
        CoroutineScope(Dispatchers.IO).launch {

        }
    }


    private fun changeFragment(tag:Int){
        _transaction=supportFragmentManager?.beginTransaction()
        ivHomeEat.isSelected=false
        ivHomeDrink.isSelected=false
        ivHomePlay.isSelected=false
        ivHomeEnjoy.isSelected=false
        tvHomeEat.isSelected=false
        tvHomeDrink.isSelected=false
        tvHomePlay.isSelected=false
        tvHomeEnjoy.isSelected=false
        eatFragment?.let {
            _transaction?.hide(it)
        }
        drinkFragment?.let {
            _transaction?.hide(it)
        }
        playFragment?.let {
            _transaction?.hide(it)
        }
        enjoyFragment?.let {
            _transaction?.hide(it)
        }

        when (tag) {
            HOME_TAG_EAT -> {
                ivHomeEat.isSelected=true
                tvHomeEat.isSelected=true
                eatFragment?.let {
                    _transaction?.show(it)
                }?:{
                    eatFragment= EatFragment()
                    _transaction?.add(R.id.layoutContent,eatFragment!!)
                }()
            }
            HOME_TAG_DRINK->{
                ivHomeDrink.isSelected=true
                tvHomeDrink.isSelected=true
                drinkFragment?.let {
                    _transaction?.show(it)
                }?:{
                    drinkFragment= DrinkFragment()
                    _transaction?.add(R.id.layoutContent,drinkFragment!!)
                }()
            }
            HOME_TAG_PLAY->{
                ivHomePlay.isSelected=true
                tvHomePlay.isSelected=true
                playFragment?.let {
                    _transaction?.show(it)
                }?:{
                    playFragment= PlayGameFragment()
                    _transaction?.add(R.id.layoutContent,playFragment!!)
                }()
            }
            HOME_TAG_ENJOY->{
                ivHomeEnjoy.isSelected=true
                tvHomeEnjoy.isSelected=true
                enjoyFragment?.let {
                    _transaction?.show(it)
                }?:{
                    enjoyFragment= EnjoyFragment()
                    _transaction?.add(R.id.layoutContent,enjoyFragment!!)
                }()
            }
            else -> {
            }
        }
        _transaction?.commitAllowingStateLoss()

    }


    fun process(x: Int, y: Int, operate: (Int, Int) -> Int) {
        println(operate(x, y))
    }


    fun test2(x:Int ,y:Int ){
        process(x,y){a:Int ,b:Int ->
           a+b
        }
    }

}

