package com.micheladrien.tt1203.di

import android.content.Context
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
@Module
@InstallIn(SingletonComponent::class)
object  AppProvideModule {

    @MyRequestQueue
    @Provides
    fun provideQueue(
            @ApplicationContext context : Context
    ): RequestQueue {
        Log.d("TestAMI", "Module")
        return Volley.newRequestQueue(context)
    }
} */