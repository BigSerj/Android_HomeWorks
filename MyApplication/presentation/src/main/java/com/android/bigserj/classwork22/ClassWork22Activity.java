package com.android.bigserj.classwork22;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.bigserj.R;

public class ClassWork22Activity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork22);

        Button mapBut = (Button) findViewById(R.id.mapButton);

        mapBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassWork22Activity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
