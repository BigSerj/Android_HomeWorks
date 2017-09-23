package com.android.bigserj.classWork16;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.bigserj.R;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;
import io.realm.RealmModel;

public class ClassWork16Activity extends Activity{

    private Realm realm;
    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private Button button;
    private UserDb userDb;

    public static void show(Activity activity){
        Intent intent = new Intent(activity, ClassWork16Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork16);


        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        button = findViewById(R.id.button16);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        realm = Realm.getDefaultInstance();

        loadData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        realm.close();
    }


    private void saveData(){

        // если user = null, т.е. не загрузился методом  loadData(),
//        то создаем новый
        if (userDb == null) {
            userDb = realm.createObject(UserDb.class,10);
            realm.beginTransaction();
            userDb.setName("yoyoyo");
//            userDb.setNameOneTwo(55);
            realm.commitTransaction();
        }

//        сохраняем юзера в БД Realm
        // если записываем в БД то нужно (1, 2):
        realm.beginTransaction();  // 1
        userDb.setName(editText.getText().toString());
//        userDb.setNameOneTwo(44);
        realm.commitTransaction(); // 2
    }

    private void loadData(){

        // userDb - это объект Realm не Java
        userDb = realm
                .where(UserDb.class)
                .equalTo("id",10)
                .findFirst();

        if (userDb != null){
            editText.setText(userDb.getName());

            userDb.addChangeListener(new RealmChangeListener<RealmModel>() {
                @Override
                public void onChange(RealmModel realmModel) {
                    // когда объект изменится на который мы повесили лисенер
                    Log.e("AAA","user changed");
//                    editText2.setText(String.valueOf(userDb.getNameOneTwo()));
                    editText3.setText(String.valueOf(userDb.getId()));
                }
            });
        }

    }


}
