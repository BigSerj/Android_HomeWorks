package com.android.bigserj.homeWork3;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.bigserj.BuildConfig;
import com.android.bigserj.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class HomeWork3Activity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_homework3);

        ImageView task1ImageView = (ImageView)findViewById(R.id.task1_image);
        TextView task1TextView = (TextView)findViewById(R.id.task1_text);

        Glide.with(this)
                .load(task1TextView.getText().toString())
                .apply(RequestOptions.circleCropTransform())
                .into(task1ImageView);



        TextView task3TextView = (TextView)findViewById(R.id.task3_text);
        task3TextView.setText(BuildConfig.API_ENDPOINT);
    }

}