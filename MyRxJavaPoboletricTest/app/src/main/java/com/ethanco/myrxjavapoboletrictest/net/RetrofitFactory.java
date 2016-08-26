package com.ethanco.myrxjavapoboletrictest.net;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;

import java.io.File;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit工厂类
 * <p>
 * Created by Zhk on 2016/1/5.
 */
public class RetrofitFactory {
    private OkHttpClient okHttpClient;
    private static final int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 20 * 1024 * 1024;

    public static RetrofitFactory getInstance() {
        return SingletonHodler.sInstance;
    }

    private static class SingletonHodler {
        private static final RetrofitFactory sInstance = new RetrofitFactory();
    }

    private static final int TIME_OUT = 15;
    private HashMap<String, Retrofit> retrofitMap = new HashMap<>();

    public Retrofit createRetrofit(String baseUrl) {
        Retrofit retrofit = retrofitMap.get(baseUrl);

        if (retrofit == null) {
            OkHttpClient client = createOkhttp();

            retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(new ToStringConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build();

            retrofitMap.put(baseUrl, retrofit);
        }

        return retrofit;
    }

    @NonNull
    public OkHttpClient createOkhttp() {
        if (null == okHttpClient) {
            File httpCacheDirectory = new File(getCacheDir(getContext()), "SmartHome_Cache");
            CookieManager cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            CookieHandler.setDefault(cookieManager);
            okHttpClient = new OkHttpClient.Builder().build();
        }

        return okHttpClient;
    }

    public static Context getContext() {
        return mContext;
    }

    private static Application mContext;

    public static void init(Application application) {
        mContext = application;
    }

    public String getCacheDir(Context context) {
        String path;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            if (null == context.getExternalCacheDir()) {
                path = Environment.getExternalStorageDirectory().getPath();
            } else {
                path = context.getExternalCacheDir().getPath();
            }
        } else {
            path = context.getCacheDir().getPath();
        }
        return path;
    }
}
