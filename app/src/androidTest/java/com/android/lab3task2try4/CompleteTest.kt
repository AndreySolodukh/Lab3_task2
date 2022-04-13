package com.android.lab3task2try4

import android.content.pm.ActivityInfo
import android.view.Gravity
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Test
import org.junit.Rule
import androidx.test.rule.ActivityTestRule




class CompleteTest {

// ------------------- Simple walks ----------------------

    @Test
    fun testWalkFirstToThird() {
        launchActivity<MainActivity>()
        Espresso.onView(withId(R.id.fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.bnToThird)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.fragment3))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testFromSecondToFirst() {
        launchActivity<MainActivity>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.bnToFirst)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testFromThirdToFirst() {
        launchActivity<MainActivity>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.bnToThird)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.bnToFirst)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testFromThirdToSecond() {
        launchActivity<MainActivity>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.bnToThird)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    // ------------------- Press Back ----------------------

    @Test
    fun testBackFromThirdToFirst() {
        launchActivity<MainActivity>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.bnToThird)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.fragment3))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.fragment3)).perform(ViewActions.pressBack())
        Espresso.onView(withId(R.id.fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.fragment2)).perform(ViewActions.pressBack())
        Espresso.onView(withId(R.id.fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testBackStackSecondToFirst() {
        launchActivity<MainActivity>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.bnToThird)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.fragment2)).perform(ViewActions.pressBack())
        Espresso.onView(withId(R.id.fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    // ------------------- About ---------------------

    @Test
    fun testAboutFromFirst() {
        launchActivity<MainActivity>()
        openAbout()
        Espresso.onView(withId(R.id.activity_about))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testAboutFromSecond() {
        launchActivity<MainActivity>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        openAbout()
        Espresso.onView(withId(R.id.activity_about))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testAboutFromThird() {
        launchActivity<MainActivity>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.bnToThird)).perform(ViewActions.click())
        openAbout()
        Espresso.onView(withId(R.id.activity_about))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testBackFromAboutToFirst() {
        launchActivity<MainActivity>()
        openAbout()
        Espresso.onView(withId(R.id.activity_about)).perform(ViewActions.pressBack())
        Espresso.onView(withId(R.id.fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testBackFromAboutToSecond() {
        launchActivity<MainActivity>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        openAbout()
        Espresso.onView(withId(R.id.activity_about)).perform(ViewActions.pressBack())
        Espresso.onView(withId(R.id.fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testBackFromAboutToThird() {
        launchActivity<MainActivity>()
        Espresso.onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.bnToThird)).perform(ViewActions.click())
        openAbout()
        Espresso.onView(withId(R.id.activity_about)).perform(ViewActions.pressBack())
        Espresso.onView(withId(R.id.fragment3))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    // --------------- Config Change Event ---------------------

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testConfigurationChange() {
        launchActivity<MainActivity>()
        Espresso.onView(withId(R.id.fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.bnToSecond)).perform(ViewActions.click())
        mActivityTestRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        Espresso.onView(withId(R.id.fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.bnToThird)).perform(ViewActions.click())
        mActivityTestRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        Espresso.onView(withId(R.id.fragment3))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun openAbout() {
        // Open Drawer to click on navigation.
        Espresso.onView(withId(R.id.drawer_layout))
            .check(ViewAssertions.matches(DrawerMatchers.isClosed(Gravity.LEFT))) // Left Drawer should be closed.
            .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        Espresso.onView(withId(R.id.about)).perform(ViewActions.click())
    }
}