package com.android.bigserj.homeWork4;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.bigserj.R;

public class AnalogClocksActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_analog_clocks);


        // запускаем поток для отсчитывания секунд
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // update TextView here!
                                setContentView(R.layout.activity_analog_clocks);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();

    }
}
