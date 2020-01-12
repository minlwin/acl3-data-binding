package com.jdc.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jdc.binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        
        binding.user = User("Mikel", "Min Lwin")
        binding.list = mutableListOf("Hello List")

        binding.map = mutableMapOf("key" to "Hello Map")

    }
}
