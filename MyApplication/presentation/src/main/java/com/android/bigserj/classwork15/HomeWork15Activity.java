package com.android.bigserj.classwork15;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.bigserj.R;
import com.android.bigserj.domain.entity.*;
import com.android.bigserj.domain.entity.Country;
import com.android.bigserj.domain.entity.User;
import com.android.bigserj.domain.interaction.AddUserToDatabaseUseCase;
import com.android.bigserj.domain.interaction.GetUserFromDatabaseUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class HomeWork15Activity extends Activity {

    private EditText editText;
    private Button button;
    private EditText editText2;
    private Button button2;
    AddUserToDatabaseUseCase addUserToDatabaseUseCase = new AddUserToDatabaseUseCase();
    GetUserFromDatabaseUseCase getUserFromDatabaseUseCase = new GetUserFromDatabaseUseCase();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_homework15);


        editText = findViewById(R.id.editTextHW15);
        button = findViewById(R.id.buttonHW15);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });


        editText2 = findViewById(R.id.editText2HW15);
        button2 = findViewById(R.id.button2HW15);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });

    }

    private void saveData() {

        Country country = new Country();
        country.setName("sssdd");

        com.android.bigserj.domain.entity.User user = new User();
        user.setName(editText.getText().toString());
        user.setAge(77);
        user.setCountry(country);

        AddUser addUser = new AddUser();
        addUser.setContext(this);
        addUser.setUser(user);


        addUserToDatabaseUseCase.execute(addUser, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {
                Log.e("AAA", "AddOK");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAAA EditError = ", e.toString());
            }

            @Override
            public void onComplete() {
                Log.e("AAAA", "onComplete");
            }
        });
    }

    private void getData(){
        com.android.bigserj.domain.entity.User user = new User();
        user.setName(editText2.getText().toString());
        user.setCountry(new Country());

        GetUser getUser = new GetUser();
        getUser.setContext(this);
        getUser.setUser(user);

        getUserFromDatabaseUseCase.execute(getUser, new DisposableObserver<User>() {
            @Override
                public void onNext(@NonNull User user) {

                // id юзера
                TextView editTextIdHW15 = (TextView) findViewById(R.id.editTextIdHW15);
                editTextIdHW15.setText(String.valueOf(user.getId()));

                // имя юзера
                TextView editTextNameHW15 = (TextView) findViewById(R.id.editTextNameUserHW15);
                editTextNameHW15.setText(String.valueOf(user.getName()));

                // возраст
                TextView editTextAgeHW15 = (TextView) findViewById(R.id.editTextAgeHW15);
                editTextAgeHW15.setText(String.valueOf(user.getAge()));

                // id Country
                TextView editTextCountryIdHW15 = (TextView) findViewById(R.id.editTextCountryHW15);
                editTextCountryIdHW15.setText(String.valueOf(user.getCountry().getId()));

                // name Country
                TextView editTextCountryNameHW15 = (TextView) findViewById(R.id.editTextNameCountryHW15);
                editTextCountryNameHW15.setText(String.valueOf(user.getCountry().getName()));


                Log.e("AAA", "getOK");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAAA EditError2 = ", e.toString());
            }

            @Override
            public void onComplete() {
                Log.e("AAAA", "onComplete");
            }
        });

    }
}
