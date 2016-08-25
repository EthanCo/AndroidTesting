package com.ethanco.myroboletrictest;

import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.ethanco.myroboletrictest.AssertM.assertIntent;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by EthanCo on 2016/8/24.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, packageName = "com.ethanco.myroboletrictest")
public class WelcomeActivityTest {

    @Test
    public void clickingLogin_shouldStartLoginActivity() {
        WelcomeActivity activity = Robolectric.setupActivity(WelcomeActivity.class);
        activity.findViewById(R.id.login).performClick();

        Intent expectedIntent = new Intent(activity, LoginActivity.class);
        //Intent expectedIntent = new Intent(activity, MyAwesomeActivity.class);

        assertIntent(expectedIntent,shadowOf(activity).getNextStartedActivity());
        //assertEquals(expectedIntent.toString(), shadowOf(activity).getNextStartedActivity().toString());
        //assertThat(shadowOf(activity).getNextStartedActivity().toString()).isEqualTo(expectedIntent.toString());
        //assertThat(shadowOf(activity).getNextStartedActivity()).isEqualTo(expectedIntent);
        //assertThat(shadowOf(activity).getNextStartedActivity(), is(expectedIntent));
    }
}
