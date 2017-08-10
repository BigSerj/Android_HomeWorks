package com.android.bigserj.homework1;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.bigserj.R;


public class MainActivity extends Activity implements View.OnClickListener{

    public static final String KEY_USERNAME = "KEY_USERNAME";
    public static final String KEY_PASSWORD = "KEY_PASSWORD";


    private Button okButton;
    private TextView text1;
    private TextView text2;

    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            String text1Buf = (String) text1.getText();
            text1.setText(text2.getText());
            text2.setText(text1Buf);
        }
    };

    @Override
    public void onClick(View view) {
        String text1Buf = (String) text1.getText();
        text1.setText(text2.getText());
        text2.setText(text1Buf);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw1);
        Log.d("MainActivity","onCreate()"); // d - debug.


        okButton = (Button)findViewById(R.id.ok_button);
        text1 = (TextView)findViewById(R.id.textView1);
        text2 = (TextView)findViewById(R.id.textView2);


        String userName = getIntent().getStringExtra(KEY_USERNAME);
        String password = getIntent().getStringExtra(KEY_PASSWORD);

        text1.setText(userName);
        text2.setText(password);

        // кнопка Ок
        okButton.setOnClickListener(listener);
        // текст 1
        text1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String text1Buf = (String) text1.getText();
                text1.setText(text2.getText());
                text2.setText(text1Buf);
            }
        });
        // текст 2
        text2.setOnClickListener(this);
    }







    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy()"); // d - debug.
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart()"); // d - debug.
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop()"); // d - debug.
    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume()"); // d - debug.
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause()"); // d - debug.1
    }



}
