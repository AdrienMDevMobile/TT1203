package com.micheladrien.tt1203

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.micheladrien.tt1203.data.APIExerciseListProvider
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class APICallTest {

    private lateinit var context: Context

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val mainActivityTestRule : ActivityTestRule<MainActivity> = ActivityTestRule<MainActivity>(
            MainActivity::class.java
    )

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun TestAPIExerciseListProvider() = runBlocking {
        val rq : RequestQueue = Volley.newRequestQueue(context)
        val gs : Gson = Gson()
        val prov = APIExerciseListProvider(rq, gs)
        val results = prov.getExerciseList()
        // Assert pages equals, is, etc.
        assertTrue(results.data.size > 0)
    }

}