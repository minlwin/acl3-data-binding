package com.jdc.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.jdc.hello.databinding.ActivityMainBinding
import com.jdc.hello.model.HelloViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        val viewModel by viewModels<HelloViewModel>()
        subjects.setAdapter(ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, viewModel.array))

        binding.viewModel = viewModel
    }
}
