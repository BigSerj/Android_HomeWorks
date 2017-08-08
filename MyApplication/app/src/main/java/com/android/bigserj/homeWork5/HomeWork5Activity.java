package com.android.bigserj.homeWork5;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

public class HomeWork5Activity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    @Override
    protected void onStart() {
        super.onStart();
        startService(new Intent(this, MyServiceHomeWork5.class));
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.e("AAAA","onStop()");

        stopService(new Intent(this, MyServiceHomeWork5.class));
    }



}