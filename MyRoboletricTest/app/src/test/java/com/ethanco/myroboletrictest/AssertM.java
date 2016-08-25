package com.ethanco.myroboletrictest;

import android.content.Intent;

import static junit.framework.Assert.assertEquals;

/**
 * Created by EthanCo on 2016/8/25.
 */
public class AssertM {
    public static void assertIntent(Intent expected, Intent actual) {
        assertEquals(expected.toString(), actual.toString());
    }
}
