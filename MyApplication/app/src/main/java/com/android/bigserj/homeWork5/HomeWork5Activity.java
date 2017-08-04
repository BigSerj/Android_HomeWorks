package com.android.bigserj.homeWork5;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.bigserj.ClassWork5.ClassWork5Activity;
import com.android.bigserj.ClassWork5.MyBroadcastReceiver;
import com.android.bigserj.ClassWork5.MyIntentService;
import com.android.bigserj.ClassWork5.MyService;
import com.android.bigserj.R;

import java.lang.reflect.Method;

public class HomeWork5Activity extends Activity{

    private static boolean inWiFi=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework5);
        startService(new Intent(this, MyServiceHomeWork5.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, MyServiceHomeWork5.class));
    }



    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("AAAA","onServiceConnected()");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("AAAA","onServiceDisconnected()");
        }
    };
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver,intentFilter);
        Log.e("AAAA","onStart()");
        Intent intent = new Intent(HomeWork5Activity.this,MyServiceHomeWork5.class);
        bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e("AAAA","onStop()");
        unregisterReceiver(receiver);
        unbindService(serviceConnection);
    }



    private BroadcastReceiver receiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("AAAA","onReceive()");

            if (inWiFi)
                Log.e("AAAA", "WiFi On/Off");
            else
                inWiFi=true;
        }
    };
}