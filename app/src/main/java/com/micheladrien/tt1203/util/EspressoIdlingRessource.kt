package com.micheladrien.tt1203.util

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingRessource {

    private const val RESOURCE = "GLOBAL"

    @JvmField val countingIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment(){
        countingIdlingResource.increment()
    }

    fun decrement(){
        if(!countingIdlingResource.isIdleNow)countingIdlingResource.decrement()
    }

}