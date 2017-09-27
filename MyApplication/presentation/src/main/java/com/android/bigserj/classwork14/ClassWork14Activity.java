package com.android.bigserj.classwork14;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.bigserj.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.id.edit;


public class ClassWork14Activity extends FragmentActivity{

    @BindView(R.id.editText)
    EditText editText;

    @BindView(R.id.button)
    Button button;

    SharedPreferences sharedPreferences;
    public static final String SHARED_PREFERENCES_NAME = "defr";
    public static final String KEY_NAME = "KEY_NAME";

    public static void show(Activity activity){
        Intent intent = new Intent(activity, ClassWork14Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork14);
        ButterKnife.bind(this);

//        button.setText("ExampleText");

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // сохраняем текст из EditText в SharedPreference
                sharedPreferences.edit().putString(KEY_NAME,String.valueOf(editText.getText()))
                        .apply();
            }
        });

        // берем данные из SharedPreferences которые сохранили и задаем из в EditText
        String data = sharedPreferences.getString(KEY_NAME,null);
        if(data != null)
            editText.setText(data);


    }

}
