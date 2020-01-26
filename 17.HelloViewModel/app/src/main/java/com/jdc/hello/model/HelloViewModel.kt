package com.jdc.hello.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HelloViewModel:ViewModel() {

    var name = MutableLiveData<String>()
    var message = MutableLiveData<String>()

    fun greet() {
        message.value = "Hello ${name.value}!"
    }
}