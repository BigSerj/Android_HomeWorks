package com.android.bigserj.classWork18;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.bigserj.BuildConfig;
import com.android.bigserj.R;

public class ClassWork18Activity extends AppCompatActivity {

    View view;
    Button button1;
    Button button2;

    public static void show(Activity activity){
        Intent intent = new Intent(activity, ClassWork18Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork18);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_cached_black_24dp);



//        view = findViewById(R.id.emptyView);
//        button1 = (Button) findViewById(R.id.button185);
//        button2 = (Button) findViewById(R.id.button186);
//
//        final View viewRoot = findViewById(R.id.root);
//
//        view.setVisibility(View.VISIBLE);
//        ViewCompat.setZ(view,50000);
//        ViewCompat.setZ(button1,50000);
//
//
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                view.bringToFront();
//                ViewCompat.setZ(viewRoot,70000);
//                ViewCompat.setZ(button2,70000);
//            }
//        });
    }


    // тут нужно указать какое меню показывать
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.classwork18_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
