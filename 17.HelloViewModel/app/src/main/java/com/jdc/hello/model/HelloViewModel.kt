package com.jdc.hello.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HelloViewModel:ViewModel() {

    val name = MutableLiveData<String>()
    val subject = MutableLiveData<String>()

    val message = MutableLiveData<String>()

    val array = arrayOf<String>("Java SE", "Java EE", "Spring", "Android")

    fun greet() {
        message.value = "Hello ${name.value}, your subject is ${subject.value}"
    }
}