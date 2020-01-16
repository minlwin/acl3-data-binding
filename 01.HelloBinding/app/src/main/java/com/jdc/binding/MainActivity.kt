package com.jdc.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.jdc.binding.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val inflater = LayoutInflater.from(this)
        val binding = ActivityMainBinding.inflate(inflater)

        setContentView(binding.root)

        binding.user = User()
        binding.list = listOf(User(firstName = "Zaw", lastName = "Min Lwin"))

        binding.map = mapOf("thidar" to User("Thidar", "Aung"))

    }
}
