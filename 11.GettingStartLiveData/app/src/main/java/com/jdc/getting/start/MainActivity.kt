package com.jdc.getting.start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generatedNumber = MutableLiveData<Int>()

        generatedNumber.observe(this, Observer<Int> {
            output.text = it.toString()
        })

        button.setOnClickListener {
            generatedNumber.value = Random.nextInt(1000, 10000)
        }
    }

}
