package com.micheladrien.tt1203


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import com.micheladrien.tt1203.exerciseList.ExerciseListVH


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class RecycleViewTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val mainActivityTestRule : ActivityTestRule<MainActivity> = ActivityTestRule<MainActivity>(
        MainActivity::class.java
    )

    val list_item_number = 4


    /**
     * Recycler view is present
     */
    @Test
    fun test_isRowItemPresent() {
        onView(withId(R.id.recycler_view_exercise)).check(matches(isDisplayed()))
    }

    /**
     * Recycler view a bien un itemù 4
     */
    @Test
    fun test_is_element4Visible(){
        onView(withId(R.id.recycler_view_exercise))
            .perform(actionOnItemAtPosition<ExerciseListVH>(list_item_number, click()))
    }
}