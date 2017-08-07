package com.android.bigserj.classWork5;


import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class MyIntentService extends IntentService{

    public static final String KEY_ACTION = "KEY_ACTION";
    public static final String MY_ACTION = "com.android.bigserj.ClassWork5.MY_ACTION";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String action = intent.getStringExtra(KEY_ACTION);
//        Log.e("AAA", "onHandleIntent() action = " +action);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent intentReceiver = new Intent(MY_ACTION);

        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);

        localBroadcastManager.sendBroadcast(intentReceiver);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("AAA","onDestroy()");
    }
}
