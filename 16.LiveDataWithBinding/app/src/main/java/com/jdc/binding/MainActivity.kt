package com.jdc.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.jdc.binding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).also {

            it.lifecycleOwner = this

            it.name = MutableLiveData("Hello")

            val checked = MutableLiveData(true)

            it.checked = checked

            it.subject = MutableLiveData("Java SE")

            it.label = Transformations.map(checked) { c ->
                if(c) "Yes" else "No"
            }
        }

        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.subjects))

        autoComplete.setAdapter(adapter)
    }
}
