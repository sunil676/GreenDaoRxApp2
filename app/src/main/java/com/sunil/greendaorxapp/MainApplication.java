package com.sunil.greendaorxapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by sunil on 11-Oct-16.
 */

public class MainApplication extends Application{

    private static Context mContext;

    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return mContext;
    }
}
