package com.jdc.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val liveData = MutableLiveData<Int>()

        liveData.observe(this, Observer {
            output1.text = it.toString()
        })

        generateBtn.setOnClickListener {
            liveData.value = Random.nextInt(1000, 10000)
            Toast.makeText(this, "Activity Observer Worked", Toast.LENGTH_SHORT).show()
        }

        val fragment = ObserverFragment(liveData)

        fragmentBtn.setOnClickListener {
            if (fragmentBtn.text == "Add Fragment") {
                supportFragmentManager.beginTransaction()
                    .add(R.id.container, fragment).commit()
                fragmentBtn.text = "Remove Fragment"
            } else {
                supportFragmentManager.beginTransaction()
                    .remove(fragment).commit()
                fragmentBtn.text = "Add Fragment"
            }
        }
    }
}
