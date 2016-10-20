package com.sunil.greendaorxapp;

import android.app.Application;
import android.content.Context;

import com.sunil.greendaorxapp.daogen.DaoMaster;
import com.sunil.greendaorxapp.daogen.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by sunil on 11-Oct-16.
 */

public class MainApplication extends Application{

    private static Context mContext;
    private DaoSession daoSession;
    public static final boolean ENCRYPTED = true;



    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();


        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public static Context getAppContext() {
        return mContext;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
