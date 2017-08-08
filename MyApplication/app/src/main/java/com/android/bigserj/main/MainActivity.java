package com.android.bigserj.main;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.android.bigserj.classWork4.ClassWork4Activity;
import com.android.bigserj.classWork5.ClassWork5Activity;
import com.android.bigserj.classWork7.ClassWork7Activity;
import com.android.bigserj.classWork6.ClassWork6Activity;
import com.android.bigserj.homeWork5.HomeWork5Activity;
import com.android.bigserj.R;
import com.android.bigserj.classWork3.ClassWork3Activity;
import com.android.bigserj.classwork2.ClassWork2Activity;
import com.android.bigserj.homeWork2.HomeWork2Activity;
import com.android.bigserj.homeWork3.HomeWork3Activity;
import com.android.bigserj.homeWork4.HomeWork4Activity;
import com.android.bigserj.homeWork6.HomeWork6Activity;


public class MainActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cw2Button = (Button)findViewById(R.id.cw2_button);
        cw2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassWork2Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button dz1Button = (Button)findViewById(R.id.dz1_button);
        dz1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.android.bigserj.homework1.MainActivity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button dz12Button = (Button)findViewById(R.id.dz2_button);
        dz12Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeWork2Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button cw3Button = (Button)findViewById(R.id.cw3_button);
        cw3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassWork3Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button hw3Button = (Button)findViewById(R.id.hw3_button);
        hw3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeWork3Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button cw4Button = (Button)findViewById(R.id.cw4_button);
        cw4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassWork4Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button hw4Button = (Button)findViewById(R.id.hw4_button);
        hw4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeWork4Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
                overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha);
            }
        });
        Button cw5Button = (Button)findViewById(R.id.cw5_button);
        cw5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassWork5Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button hw5Button = (Button)findViewById(R.id.hw5_button);
        hw5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeWork5Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button cw6Button = (Button)findViewById(R.id.cw6_button);
        cw6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassWork6Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button hw6Button = (Button)findViewById(R.id.hw6_button);
        hw6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeWork6Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button cw7Button = (Button)findViewById(R.id.cw7_button);
        cw7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassWork7Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });

    }


}
