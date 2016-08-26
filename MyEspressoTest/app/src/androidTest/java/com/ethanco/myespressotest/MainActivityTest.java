package com.ethanco.myespressotest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by EthanCo on 2016/8/26.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRele = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void greet() {
        onView(withId(R.id.greeting)).check(matches(withText("")));

        onView(withId(R.id.greet_button)).check(matches(withText(R.string.greet))).perform(click());

        onView(withId(R.id.greeting)).check(matches(withText(R.string.hello)));
    }
}
