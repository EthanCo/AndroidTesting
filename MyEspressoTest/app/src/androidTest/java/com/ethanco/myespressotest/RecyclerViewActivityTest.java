package com.ethanco.myespressotest;

import android.app.Activity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by EthanCo on 2016/8/26.
 */
@RunWith(AndroidJunit4.class)
public class RecyclerViewActivityTest {
    @Rule
    ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(RecyclerviewActivity.class);

    @Test
    public void clickItem() {
        onView(R.id.recycler_view)
                .perform(RecyclerViewActions.actionOnItemAtPosition(27,cdlick()));

        onView(withId(R.id.text))
                .check(matches(withText("27")))
                .check(matches(isDisplayed()))
    }
}
