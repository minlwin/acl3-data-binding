package com.jdc.observable.model

import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel

abstract class ObservableViewModel:ViewModel(), Observable {

    private val registry = PropertyChangeRegistry()

    override fun removeOnPropertyChangedCallback(
        callback: Observable.OnPropertyChangedCallback?) {
        registry.remove(callback)
    }

    override fun addOnPropertyChangedCallback(
        callback: Observable.OnPropertyChangedCallback?) {
        registry.add(callback)
    }

    fun notifyChange() {
        registry.notifyChange(this, 0)
    }

    fun notifyChange(resourceId:Int) {
        registry.notifyChange(this, resourceId)
    }
}