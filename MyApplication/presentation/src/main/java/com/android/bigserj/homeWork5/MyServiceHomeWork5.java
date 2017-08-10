package com.android.bigserj.homeWork5;


import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyServiceHomeWork5 extends Service{

    MyBroadcastReceiverHomeWork5 myBroadcastReceiverHomeWork5 = new MyBroadcastReceiverHomeWork5();


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


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(LOG_TAG,"onStartCommand()");

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(myBroadcastReceiverHomeWork5, intentFilter);

        return super.onStartCommand(intent, flags, startId);
    }




    @Override
    public void onDestroy() {
        unregisterReceiver(myBroadcastReceiverHomeWork5);
        Log.e(LOG_TAG,"onDestroy()");
        super.onDestroy();
    }






}