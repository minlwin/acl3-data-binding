package com.jdc.share.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class StudentModel:ViewModel() {

    val name = MutableLiveData<String>("Min Lwin")
    val entranceDate = MutableLiveData<Date>().also {
        it.value = Date()
    }
    val subject = MutableLiveData<String>("Android")

    val subjects = arrayOf("Java SE", "Java EE", "Spring", "Android")
}