package com.gy.coolweather;

import android.app.Application;
import android.content.Context;

/**
 * Created by yanggao on 18/6/13.
 */
public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
