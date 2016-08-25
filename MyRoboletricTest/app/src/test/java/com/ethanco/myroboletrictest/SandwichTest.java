package com.ethanco.myroboletrictest;

import android.app.Activity;
import android.os.Bundle;

import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class SandwichTest {
    //Activity activity = Robolectric.buildActivity(MyAwesomeActivity.class).create().start().resume().visible().get();

    /*Intent intent = new Intent(Intent.ACTION_VIEW);
    Activity activity = Robolectric.buildActivity(MyAwesomeActivity.class).withIntent(intent).create().get();*/

    Bundle savedInstanceState = new Bundle();
    Activity activity = Robolectric.buildActivity(MyAwesomeActivity.class)
            .create()
            .restoreInstanceState(savedInstanceState)
            .get();
}