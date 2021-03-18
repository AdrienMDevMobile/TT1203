package com.micheladrien.tt1203.volley.internetConnection

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresApi

class NetworkMonitor

//Started in the Application
constructor(private val application: Application) {

    fun startNetworkCallback() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val cm: ConnectivityManager =
                    application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val builder: NetworkRequest.Builder = NetworkRequest.Builder()

            //L'object networkCallback est enregistré pour recevoir les messages de NetworkCallback.
            /**Check if version code is greater than API 24 or 23 to 21*/
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                cm.registerDefaultNetworkCallback(networkCallback)
            } else {
                cm.registerNetworkCallback(
                        builder.build(), networkCallback
                )
            }
        }
        else {
            //Nous ne gerons pas pour moins de 21
                Variables.isNetworkConnected = true
        }
    }

    fun stopNetworkCallback() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val cm: ConnectivityManager =
                    application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            cm.unregisterNetworkCallback(ConnectivityManager.NetworkCallback())
        }
    }

    //Va mettre à jour mes observables quand le reseau est récupéré ou perdu
    private val networkCallback = @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    object : ConnectivityManager.NetworkCallback() {

        override fun onAvailable(network: Network) {
            Variables.isNetworkConnected = true
        }

        override fun onLost(network: Network) {
            Variables.isNetworkConnected = false
        }
    }

}