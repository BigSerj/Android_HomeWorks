package com.android.bigserj.homeWork14;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.bigserj.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class HomeWork14Activity extends Activity {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, HomeWork14Activity.class);
        activity.startActivity(intent);
    }

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREFERENCES_NAME = "SPN";
    private static final String KEY_NAME = "KEY_NAME";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework14);


        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);



        ArrayList<String> countriesNames = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(getStringFromAssetFile(this));
            Log.i(HomeWork14Activity.class.getName(),
                    "Number of entries " + jsonArray.length());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                countriesNames.add(jsonObject.optString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countriesNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.countries_spinner);
        spinner.setAdapter(adapter);
        // выделяем элемент
        // берем данные из SharedPreferences которые сохранили и задаем из в EditText
        String data = sharedPreferences.getString(KEY_NAME,null);
        if(data != null)
            spinner.setSelection(Integer.valueOf(data));
        else
            spinner.setSelection(2);
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position2, long id) {
                // показываем позиция нажатого элемента
                Toast.makeText(getBaseContext(), "Position = " + position2, Toast.LENGTH_SHORT).show();
                // сохраняем текст из EditText в SharedPreference
                sharedPreferences.edit().putString(KEY_NAME,String.valueOf(position2)).apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }


    String getStringFromAssetFile(Activity activity) throws IOException {
        AssetManager am = activity.getAssets();
        InputStream is = am.open("countries.json");
        String s = convertStreamToString(is);
        is.close();
        return s;
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
