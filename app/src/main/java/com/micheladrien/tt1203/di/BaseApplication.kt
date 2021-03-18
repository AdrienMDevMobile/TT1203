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