package com.ethanco.myroboletrictest;

import android.content.Intent;

import static junit.framework.Assert.assertEquals;

/**
 * Created by EthanCo on 2016/8/25.
 */
public class AssertM {
    /**
     * 由于robolectric:3.1.X在assetThat Intent时的bug导致比较不成功，故暂时使用该方法
     *
     * @param expected
     * @param actual
     */
    public static void assertIntent(Intent expected, Intent actual) {
        assertEquals(expected.toString(), actual.toString());
    }
}
