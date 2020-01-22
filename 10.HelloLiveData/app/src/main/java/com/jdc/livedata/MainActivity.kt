package com.jdc.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.jdc.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil
            .setContentView<ActivityMainBinding>(this,
                R.layout.activity_main)
        binding.lifecycleOwner = this

        binding.hello = MutableLiveData<String>().also {
            it.value = "Test"
        }
    }
}
