package com.jdc.transforms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val source1 = MutableLiveData<Int>().also {
        it.value = 1000
    }
    private val source2 = MutableLiveData<Int>().also {
        it.value = 2000
    }

    private val switchSource = MutableLiveData<Boolean>().also {
        it.value = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        source1.observe(this, Observer {
            out1.text = source1.value.toString()
        })

        Transformations.map(source2) { it.toString() }
            .observe(this, Observer {
                out2.text = it
            })

        Transformations.switchMap(switchSource) {
            if(it) source2 else source1
        }.observe(this, Observer {
            switchOut.text = it.toString()
        })

        switchBtn.setOnCheckedChangeListener { _, isChecked ->
            switchSource.value = isChecked
        }
    }

    fun updateSource1(v:View) = v.also {
        source1.value = Random.nextInt(1000, 10000)
    }

    fun updateSource2(v: View) = v.also {
        source2.value = Random.nextInt(1000, 10000)
    }

}
