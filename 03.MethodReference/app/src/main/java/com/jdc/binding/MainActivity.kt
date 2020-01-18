package com.jdc.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jdc.binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityMainBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)

        binding.counter = Counter {
            this
        }

        binding.checkListener = CheckListener(binding)
    }

}
