package com.android.bigserj.homeWork4;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.bigserj.R;
import com.android.bigserj.main.MainActivity;

public class HomeWork4Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework4);



        ImageView imageOwl = (ImageView) findViewById(R.id.owlImage);
        imageOwl.setBackgroundResource(R.drawable.owl_animation);
        AnimationDrawable animationOwl = (AnimationDrawable) imageOwl.getBackground();
        animationOwl.start();



        Button hw42Button = (Button)findViewById(R.id.task4_Clocks);
        hw42Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeWork4Activity.this, AnalogClocksActivity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
                overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha);
            }
        });

    }



}