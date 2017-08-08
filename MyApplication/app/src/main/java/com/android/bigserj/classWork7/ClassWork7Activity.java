package com.android.bigserj.classWork7;


import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.bigserj.R;
import com.android.bigserj.databinding.ActivityClasswork7Binding;

public class ClassWork7Activity extends Activity{

    public ObservableField<String> myText = new ObservableField<>("YoYoYo");

    private Thread tehread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityClasswork7Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_classwork7);

        binding.setActivity(this);

        binding.superTextView.setText("fwdfwg");


    }


    @Override
    protected void onResume() {
        super.onResume();
        tehread = new Thread(new Runnable(){
            @Override
            public void run() {
                 for (int i=0;i<3;i++){
                     final int a =i;
                     try {
                         Thread.sleep(2000);
                     } catch (InterruptedException e) {}
                     runOnUiThread(new Runnable(){
                         @Override
                         public void run() {
                            myText.set(String.valueOf(a));
                         }
                     });
                 }
            }
        });
        tehread.start();
    }
}
