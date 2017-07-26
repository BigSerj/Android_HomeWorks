package com.android.bigserj.classwork2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.bigserj.R;
import com.android.bigserj.homework1.MainActivity;


public class ClassWork2Activity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork2);

        final EditText username = (EditText) findViewById(R.id.userNameText);
        final EditText password = (EditText) findViewById(R.id.password);
        Button loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassWork2Activity.this,com.android.bigserj.homework1.MainActivity.class);
                intent.putExtra(MainActivity.KEY_USERNAME,username.getText());
                intent.putExtra(MainActivity.KEY_PASSWORD,password.getText());
                startActivity(intent);
            }
        });

    }



}
