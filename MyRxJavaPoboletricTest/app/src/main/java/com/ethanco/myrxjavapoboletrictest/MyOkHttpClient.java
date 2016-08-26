package com.ethanco.myrxjavapoboletrictest;

import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowView;

import okhttp3.OkHttpClient;

/**
 * Created by EthanCo on 2016/8/25.
 */
@Implements(OkHttpClient.class)
public class MyOkHttpClient extends ShadowView {
}
