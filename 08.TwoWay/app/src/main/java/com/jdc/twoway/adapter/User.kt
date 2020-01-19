package com.jdc.twoway.adapter

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import java.util.*

class User: BaseObservable {

    @get:Bindable
    var name:String = ""
        set(value) {
            if(value != field) {
                field = value
                notifyPropertyChanged(BR.name)
            }
        }

    @get:Bindable
    var itRelated:Boolean = false
        set(value) {
            if(field != value) {
                field = value
                notifyPropertyChanged(BR.itRelated)
                notifyPropertyChanged(BR.itString)
            }
        }

    @get:Bindable
    val itString:String
        get() = if (itRelated) "Yes" else "No"

    @get:Bindable
    var dob:Date? = null
        set(value) {
            if(value != field) {
                field = value
                notifyPropertyChanged(BR.dob)
            }
        }

    constructor(name: String = "", it:Boolean = false, dob:Date? = null) {
        this.name = name
        this.itRelated = it
        this.dob = dob
    }
}