package com.micheladrien.tt1203.di

import android.app.Application
import com.micheladrien.tt1203.volley.internetConnection.NetworkMonitor

open class BaseApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        //Start network callback
        NetworkMonitor(this).startNetworkCallback()
    }

    override fun onTerminate(){
        super.onTerminate()
        //Stop network callback
        NetworkMonitor(this).stopNetworkCallback()
    }
}