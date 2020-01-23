package com.jdc.mediator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val source1 = MutableLiveData<Int>().also {
        it.value = 0
    }

    private val source2 = MutableLiveData<Int>().also {
        it.value = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        source1.observe(this, Observer { out1.text = it.toString() })
        source2.observe(this, Observer { out2.text = it.toString() })

        val mediator = MediatorLiveData<Int>()

        mediator.addSource(source1) {
            mediator.value = it
        }
        mediator.addSource(source2) {
            mediator.value = it
        }

        mediator.observe(this, Observer {
            out.text = it.toString()
        })
    }

    fun change1(v:View) = v.also {
        source1.value = Random.nextInt(1000, 10000)
    }

    fun change2(v:View) = v.also {
        source2.value = Random.nextInt(1000, 10000)
    }
}
