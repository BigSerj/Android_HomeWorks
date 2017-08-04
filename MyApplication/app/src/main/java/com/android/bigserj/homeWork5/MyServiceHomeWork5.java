package com.android.bigserj.homeWork5;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyServiceHomeWork5 extends Service{

    private static final String LOG_TAG = "AAAA";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(LOG_TAG,"onCreate()");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(LOG_TAG,"onBind()");
        return null;
    }



    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(LOG_TAG,"onUnbind()");
        return super.onUnbind(intent);
    }


//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.e(LOG_TAG,"onStartCommand()");
//        return super.onStartCommand(intent, flags, startId);
//    }




    @Override
    public void onDestroy() {
        Log.e(LOG_TAG,"onDestroy()");
        super.onDestroy();
    }



}