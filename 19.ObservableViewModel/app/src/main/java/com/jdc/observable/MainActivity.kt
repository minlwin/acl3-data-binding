package com.jdc.observable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.jdc.observable.databinding.ActivityMainBinding
import com.jdc.observable.model.AccountModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val model by viewModels<AccountModel>()
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, model.subjects)
        selectInput.setAdapter(adapter)

        binding.model = model
        binding.lifecycleOwner = this
    }
}
