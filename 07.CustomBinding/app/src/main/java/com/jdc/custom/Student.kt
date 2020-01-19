package com.jdc.custom

import androidx.databinding.library.baseAdapters.BR
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import java.util.*

class Student: BaseObservable {


    constructor(name:String, dob:Date, grade:Int) {
        this.name = name
        this.dob = dob
        this.grade = grade
    }

    @get:Bindable
    var name:String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var dob:Date = Date()
        set(value) {
            field = value
            notifyPropertyChanged(BR.dob)
        }

    @get:Bindable
    var grade:Int = 1
        set(value) {
            field = value
            notifyPropertyChanged(BR.grade)
        }
}