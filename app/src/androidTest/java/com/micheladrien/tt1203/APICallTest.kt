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
        val prov = APIExerciseListProvider(context)
        val results = prov.getExerciseList()
        // Assert pages equals, is, etc.
        assertTrue(results.data.size > 0)
    }

}