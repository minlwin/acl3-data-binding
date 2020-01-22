package com.jdc.extend

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import androidx.lifecycle.LiveData

class ConnectivityLiveData private constructor(private val context: Context)
    :LiveData<String>(){

    private var service = context
        .getSystemService(Context.CONNECTIVITY_SERVICE)
            as ConnectivityManager

    private var listener = object :
        ConnectivityManager.NetworkCallback() {

        override fun onAvailable(network: Network) {
            postValue("Network is Available!")
        }

        override fun onLost(network: Network) {
            postValue("Network has been lost!")
        }
    }

    override fun onActive() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            service.registerDefaultNetworkCallback(listener)
        }
    }

    override fun onInactive() {
        service.unregisterNetworkCallback(listener)
    }

    companion object {

        private lateinit var instance:ConnectivityLiveData

        fun getInstance(context: Context) =
            if(::instance.isInitialized) instance else
                ConnectivityLiveData(context).also {
                    instance = it
                }
    }

}