package com.jdc.custom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.jdc.custom.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {


    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.student = Student("Aung Aung", Date(), 2)
    }

    fun change(v:View) = when((v as Button).text) {
        "Change Name" -> chaneName()
        "Change Date" -> changeDob()
        else -> changeGrade()
    }

    private fun chaneName() {
        val name = binding.student?.name ?: "Aung Aung"
        binding.student?.name = if(name == "Aung Aung") "Maung Maung" else "Aung Aung"
        Log.d("CUSTOM", binding.student?.name)
    }

    private fun changeDob() {

        val dob = binding.student?.dob ?: Date()
        val calendar = Calendar.getInstance()
        calendar.time = dob

        calendar.add(Calendar.DAY_OF_MONTH, 1)
        binding.student?.dob = calendar.time
    }

    private fun changeGrade() {
        val grade = binding.student?.grade ?: 1
        binding.student?.grade = grade + 1
    }
}
