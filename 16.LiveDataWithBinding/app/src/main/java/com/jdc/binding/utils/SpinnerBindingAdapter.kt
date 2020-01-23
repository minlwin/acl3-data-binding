package com.jdc.binding.utils

import android.database.DataSetObserver
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

object SpinnerBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:selection")
    fun setSelection(spinner: Spinner, value:String?) = value?.let {

        for (index in 0 until spinner.adapter.count) {
            if(it == spinner.getItemAtPosition(index)) {
                spinner.setSelection(index)
            }
        }
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "app:selection")
    fun getSelection(spinner: Spinner) = spinner.selectedItem as String?

    @JvmStatic
    @BindingAdapter("app:selectionAttrChanged")
    fun setListener(spinner: Spinner, listener: InverseBindingListener) {
        spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                listener.onChange()
            }

        }
    }
}