package com.gy.coolweather;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;

/**
 * Created by yanggao on 18/6/13.
 */
public class MyApplication extends LitePalApplication {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        LitePal.initialize(this);//litepal数据库初始化
    }

    public static Context getContext() {
        return mContext;
    }
}
