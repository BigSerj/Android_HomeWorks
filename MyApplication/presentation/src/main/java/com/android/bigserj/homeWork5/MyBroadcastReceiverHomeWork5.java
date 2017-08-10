package com.android.bigserj.homeWork5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

public class MyBroadcastReceiverHomeWork5 extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("AAAA","WiFi On/Off");

    }


}