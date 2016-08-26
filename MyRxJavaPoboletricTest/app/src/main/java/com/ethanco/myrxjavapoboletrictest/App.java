package com.ethanco.myrxjavapoboletrictest;

import android.app.Application;

import com.ethanco.myrxjavapoboletrictest.net.RetrofitFactory;

/**
 * Created by EthanCo on 2016/8/25.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitFactory.init(this);
    }
}
