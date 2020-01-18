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

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil
            .setContentView<ActivityMainBinding>(this,
                R.layout.activity_main)

        binding.map = ObservableArrayMap<String, String>()
    }

    fun addName(v:View?) {
        binding.map?.put("name", name.text.toString())
    }

    fun addPhone(v:View?) {
        binding.map?.put("phone", phone.text.toString())
    }

    fun addEmail(v:View?) {
        binding.map?.put("email", email.text.toString())
    }
}
