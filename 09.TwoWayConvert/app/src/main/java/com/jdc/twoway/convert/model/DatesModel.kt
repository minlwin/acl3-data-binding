package com.jdc.twoway.convert.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import java.util.*

class DatesModel:BaseObservable() {

    @get:Bindable
    var converterDate:Date = Date()
        set(value) {
            if(field != value) {
                field = value
                notifyPropertyChanged(BR.converterDate)
            }
        }

    @get:Bindable
    var adapterDate:Date = Date()
        set(value) {
            if(field != value) {
                field = value
                notifyPropertyChanged(BR.adapterDate)
            }
        }

}