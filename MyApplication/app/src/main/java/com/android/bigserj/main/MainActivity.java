package com.android.bigserj.main;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.android.bigserj.R;
import com.android.bigserj.classWork3.ClassWork3Activity;
import com.android.bigserj.classwork2.ClassWork2Activity;
import com.android.bigserj.homeWork2.HomeWork2Activity;
import com.android.bigserj.homeWork3.HomeWork3Activity;


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


    }


}
