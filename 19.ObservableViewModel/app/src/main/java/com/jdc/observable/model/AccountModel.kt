package com.jdc.observable.model

import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class AccountModel:ObservableViewModel() {

    @get:Bindable
    var name:String = ""
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.name)
            }
        }

    @get:Bindable
    var subject:String = ""
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.subject)
            }
        }

    val subjects = listOf<String>("Java SE",
        "Kotlin", "Spring", "Android")
}