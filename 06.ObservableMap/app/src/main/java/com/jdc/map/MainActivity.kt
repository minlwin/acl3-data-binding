package com.jdc.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableMap
import com.jdc.map.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var map:ObservableMap<String, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        map = ObservableArrayMap<String, String>()
        binding.map = map
    }

    fun addName(v:View) {
        map["name"] = name.text.toString()
    }

    fun addPhone(v:View) {
        map["phone"] = phone.text.toString()
    }

    fun addEmail(v:View) {
        map["email"] = email.text.toString()
    }
}
