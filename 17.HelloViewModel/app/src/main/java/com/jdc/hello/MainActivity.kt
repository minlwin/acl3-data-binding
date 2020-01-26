package com.jdc.hello

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jdc.hello.databinding.ActivityMainBinding
import com.jdc.hello.model.HelloViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil
            .setContentView<ActivityMainBinding>(this,
                R.layout.activity_main)

        binding.lifecycleOwner = this

        val viewModel by viewModels<HelloViewModel>()

        binding.model = viewModel

    }
}
