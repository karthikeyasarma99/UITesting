package com.example.expressotesting

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun checkActivityVisibility() {
        onView(withId(R.id.activity_main))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkingTextVisibility() {
        onView(withId(R.id.tvMainActivity))
            .check(matches(isDisplayed()))

        onView(withId(R.id.btnMainActivity))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkTextIsMainActivity() {
        onView(withId(R.id.tvMainActivity))
            .check(matches(withText(R.string.main_activity)))
    }

    @Test
    fun navigateTo2Activity() {
        onView(withId(R.id.btnMainActivity))
            .perform(click())

        onView(withId(R.id.activity_second))
            .check(matches(isDisplayed()))
    }

    @Test
    fun backPressToMainActivity() {
        onView(withId(R.id.btnMainActivity))
            .perform(click())
        onView(withId(R.id.activity_second))
            .check(matches(isDisplayed()))

        Espresso.pressBack()

        onView(
            withId(R.id.activity_main))
                .check(matches(isDisplayed()))
    }
}
