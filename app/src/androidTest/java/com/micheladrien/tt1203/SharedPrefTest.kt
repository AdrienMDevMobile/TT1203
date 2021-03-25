package com.micheladrien.tt1203

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.google.gson.Gson
import com.micheladrien.tt1203.data.SampleExerciseListProvider
import com.micheladrien.tt1203.data.SharedPrefListProvider
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class SharedPrefTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val mainActivityTestRule : ActivityTestRule<MainActivity> = ActivityTestRule<MainActivity>(
        MainActivity::class.java
    )

    @Test
    fun testSharedPreferences(){
        val spp =  SharedPrefListProvider(Gson(), ApplicationProvider.getApplicationContext())
        spp.putSharedPreferences(SampleExerciseListProvider().getExerciseList2())
        val toTest = spp.getSharedPreferences()
        assertTrue(toTest.data.size == 10)
    }

}