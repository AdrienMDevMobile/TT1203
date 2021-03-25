package com.micheladrien.tt1203.di

import android.app.Application
import android.os.Build
import com.micheladrien.tt1203.volley.internetConnection.NetworkMonitor
import com.micheladrien.tt1203.volley.internetConnection.Variables

open class BaseApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        //Start network callback
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            NetworkMonitor(this).startNetworkCallback()
        }
        else {
            /**
             * Under 21, Callback manager does not exists. ConnectivityManager needs to be used. But it cannot do any callbacks from the background.
             * Here are some work around I tried implementing : create a second Network monitor that would use CM in an until CM returns that the connectivity is on.
             * On creation of the application, either the class NetworkMonitor using CallbackManager  or the one using Connectivity manager.
             */
            Variables.isNetworkConnected = true
        }
    }

    override fun onTerminate(){
        super.onTerminate()
        //Stop network callback
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            NetworkMonitor(this).stopNetworkCallback()
        }
    }
}