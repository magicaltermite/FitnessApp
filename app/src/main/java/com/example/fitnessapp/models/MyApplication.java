package com.example.fitnessapp.models;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static Context mContext;


    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context mContext) {
        MyApplication.mContext = mContext;
    }
}
