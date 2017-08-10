package com.android.bigserj.classWork6;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.bigserj.R;

import java.util.ArrayList;

public class ClassWork6Activity extends Activity {

    private RecyclerView recyclerView;
    private ArrayList<String> stringArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork6);

        // тут имеем данные
        stringArrayList.add("Item 1");
        stringArrayList.add("Item 2");
        stringArrayList.add("Item 3");
        stringArrayList.add("Item 4");
        stringArrayList.add("Item 5");


        // тут блок отвечающий за расстановку (форму) на экране
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        // как будут расставляться элементы
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        // вносим в recyclerView linearLayoutManager чтобы он знал как прорисовывать
        recyclerView.setLayoutManager(linearLayoutManager);



        //
        ClassWork6Adapter adapter = new ClassWork6Adapter(stringArrayList);

        adapter.setListener(new ClassWork6Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
                Log.e("AAA","onItemClick" + item);
            }
        });

        recyclerView.setAdapter(adapter);

    }
}
