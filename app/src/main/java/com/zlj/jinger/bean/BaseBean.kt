package com.zlj.jinger.bean

class BaseBean  {
    var name:String
    var age:Int

    init {
        age=18
        name="周杰伦"
    }
    constructor(age:Int,name:String){
        this.age=age
        this.name=name
    }

}