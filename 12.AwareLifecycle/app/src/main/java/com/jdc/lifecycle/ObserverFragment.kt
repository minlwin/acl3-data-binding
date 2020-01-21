package com.jdc.lifecycle


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_observer.*

class ObserverFragment(private val liveData: LiveData<Int>) :
    Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_observer,
            container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        liveData.observe(this, Observer {
            out2.text = it.toString()
            Toast.makeText(this.context,
                "Fragment Observer Work", Toast.LENGTH_SHORT).show()
        })
    }
}
