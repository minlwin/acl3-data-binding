package com.jdc.twoway.convert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jdc.twoway.convert.databinding.ActivityMainBinding
import com.jdc.twoway.convert.model.DatesModel
import com.jdc.twoway.convert.utils.DatePickerFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.model = DatesModel()

        DatePickerFactory.generate(converter)
        DatePickerFactory.generate(adapter)
        DatePickerFactory.generate(adapter)
    }
}
