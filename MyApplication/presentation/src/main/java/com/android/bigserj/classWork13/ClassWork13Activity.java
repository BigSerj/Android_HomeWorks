package com.android.bigserj.classWork13;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.android.bigserj.R;

public class ClassWork13Activity extends FragmentActivity {


    public static void show(Activity activity){
        Intent intent = new Intent(activity, ClassWork13Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork13);


        if (savedInstanceState == null){
            showFragment(getSupportFragmentManager(),new ClassWork13V1Fragment(),true);
        }


        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(getSupportFragmentManager(),new ClassWork13V1Fragment(), true);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(getSupportFragmentManager(),new ClassWork13V2Fragment(), true);
            }
        });
    }


    public static void showFragment(FragmentManager fragmentManager, Fragment fragment,
                                    boolean addToBackStack){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment,fragment.getClass().getName());
        if (addToBackStack) fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



}
