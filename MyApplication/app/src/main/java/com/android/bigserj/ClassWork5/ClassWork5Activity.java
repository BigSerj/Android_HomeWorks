package com.android.bigserj.ClassWork5;


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
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.bigserj.R;

public class ClassWork5Activity extends Activity{

    private TextView textView;
    private int i=0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork5);

        Intent intent = new Intent(ClassWork5Activity.this,MyIntentService.class);
        intent.putExtra(MyIntentService.KEY_ACTION,"Задание 0");
        startService(intent);

        Intent intent2 = new Intent(ClassWork5Activity.this,MyIntentService.class);
        intent2.putExtra(MyIntentService.KEY_ACTION,"Задание 1");
        startService(intent2);

        Intent intent3 = new Intent(ClassWork5Activity.this,MyIntentService.class);
        intent3.putExtra(MyIntentService.KEY_ACTION,"Задание 2");
        startService(intent3);



        textView = (TextView)findViewById(R.id.classwork5);

//        startService(new Intent(this,MyService.class));

        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(ClassWork5Activity.this,MyService.class);
//                stopService(intent);
            }
        });
    }






    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("AAA","onServiceConnected()");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("AAA","onServiceDisconnected()");
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(MyIntentService.MY_ACTION);
        registerReceiver(receiver,intentFilter);

        Intent intent = new Intent(ClassWork5Activity.this,MyService.class);
        bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);



    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
        unbindService(serviceConnection);
    }

    private BroadcastReceiver receiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("AAAA","onReceive");
            i++;
            textView.setText("i = "+i);
        }
    };

}