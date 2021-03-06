package com.android.bigserj.main;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.android.bigserj.classWork16.ClassWork16Activity;
import com.android.bigserj.classWork18.ClassWork18Activity;
import com.android.bigserj.classWork21.RegisterActivity;
import com.android.bigserj.classwork14.ClassWork14Activity;
import com.android.bigserj.classwork15.HomeWork15Activity;
import com.android.bigserj.classwork22.ClassWork22Activity;
import com.android.bigserj.homeWork13.HomeWork13Activity;
import com.android.bigserj.classWork12.ClassWork12Activity;
import com.android.bigserj.classWork13.ClassWork13Activity;
import com.android.bigserj.homeWork10.HomeWork10Activity;
import com.android.bigserj.homeWork11.HomeWork11Activity;
//import com.android.bigserj.homeWork14.HomeWork14Activity;
import com.android.bigserj.homeWork14.HomeWork14Activity;
import com.android.bigserj.homeWork9.HomeWork9Activity;
import com.android.bigserj.classWork4.ClassWork4Activity;
import com.android.bigserj.classWork5.ClassWork5Activity;
import com.android.bigserj.classWork7.ClassWork7Activity;
import com.android.bigserj.classWork6.ClassWork6Activity;
import com.android.bigserj.classwork9.ClassWork9Activity;
import com.android.bigserj.homeWork5.HomeWork5Activity;
import com.android.bigserj.R;
import com.android.bigserj.classWork3.ClassWork3Activity;
import com.android.bigserj.classwork2.ClassWork2Activity;
import com.android.bigserj.homeWork2.HomeWork2Activity;
import com.android.bigserj.homeWork3.HomeWork3Activity;
import com.android.bigserj.homeWork4.HomeWork4Activity;
import com.android.bigserj.homeWork6.HomeWork6Activity;
import com.android.bigserj.homeWork7.HomeWork7Activity;
import com.android.bigserj.classwork8.ClassWork8Activity;


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
        Button hw7Button = (Button)findViewById(R.id.hw7_button);
        hw7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeWork7Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button cw8Button = (Button)findViewById(R.id.cw8_button);
        cw8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassWork8Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button cw9Button = (Button)findViewById(R.id.cw9_button);
        cw9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassWork9Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button hw9Button = (Button)findViewById(R.id.hw9_button);
        hw9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeWork9Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button hw10Button = (Button)findViewById(R.id.hw10_button);
        hw10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeWork10Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button hw11Button = (Button)findViewById(R.id.hw11_button);
        hw11Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeWork11Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button cw12Button = (Button)findViewById(R.id.cw12_button);
        cw12Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassWork12Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button cw13Button = (Button)findViewById(R.id.cw13_button);
        cw13Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassWork13Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button hw13Button = (Button)findViewById(R.id.hw13_button);
        hw13Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeWork13Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button cw14Button = (Button)findViewById(R.id.cw14_button);
        cw14Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassWork14Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button hw14Button = (Button)findViewById(R.id.hw14_button);
        hw14Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeWork14Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button cw16Button = (Button)findViewById(R.id.cw16_button);
        cw16Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassWork16Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button hw15Button = (Button)findViewById(R.id.hw15_button);
        hw15Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeWork15Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button cw18Button = (Button)findViewById(R.id.cw18_button);
        cw18Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassWork18Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button cw21Button = (Button)findViewById(R.id.cw21_button);
        cw21Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
        Button cw22Button = (Button)findViewById(R.id.cw22_button);
        cw22Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClassWork22Activity.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
                startActivity(intent);
            }
        });
    }


}
