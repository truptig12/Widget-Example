package com.herts.studyexamples

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel():ViewModel() {

    val quoteLiveData = MutableLiveData("See ya Pal!")

    fun updateQuote(){
        quoteLiveData.value = "Ok Cool"
    }

   /* var count:Int =0

    fun increment(){
        count++
    }*/
}