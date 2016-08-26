package com.ethanco.myespressotest;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.format.DateUtils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by EthanCo on 2016/8/26.
 */
@RunWith(AndroidJUnit4.class)
public class TimingActivityTest {
    @Rule
    public ActivityTestRule<TimingActivity> activityRele = new ActivityTestRule<>(TimingActivity.class);

    @Before
    public void resetTimeout() {
        IdlingPolicies.setMasterPolicyTimeout(60, TimeUnit.SECONDS);
        IdlingPolicies.setIdlingResourceTimeout(26, TimeUnit.SECONDS);
    }

    @Test
    public void waitFor8Seconds() {
        waitFor(DateUtils.SECOND_IN_MILLIS * 8, false);
    }

    @Test
    public void waitFor75Seconds() {
        waitFor(DateUtils.SECOND_IN_MILLIS * 75, true);
    }

    private static void waitFor(long waitingTime, boolean success) {
        //Start
        onView(withId(R.id.toggle_button))
                .check(matches(withText(R.string.start)))
                .perform(click());

        //Mack sure Espresso does not time out
        IdlingPolicies.setMasterPolicyTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(waitingTime * 2, TimeUnit.MILLISECONDS);

        //Now we wait
        IdlingResource idlingResource = new ElapsedTimeIdlingResource(waitingTime);
        Espresso.registerIdlingResources(idlingResource);

        //Stop and verify
        onView(withId(R.id.toggle_button))
                .check(matches(withText(R.string.stop)))
                .perform(click());
        onView(withId(R.id.result))
                .check(matches(withText(success ? R.string.success : R.string.failure)));

        //Clean up
        Espresso.unregisterIdlingResources(idlingResource);
    }
}
